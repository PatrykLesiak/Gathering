package pl.agh.wfiis;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.database.Participant;
import pl.agh.wfiis.database.ParticipantToEvent;
import pl.agh.wfiis.model.EventsModel;
import pl.agh.wfiis.model.ParticipantModel;

@Named(value = "reportManager")
@RequestScoped
public class ReportManager {

    @EJB
    ParticipantModel participantModel;
    
    @EJB
    EventsModel eventsModel;
    
    public ReportManager() {}
    
    public void createReport(int eventId) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        
        writeReportHeader(workbook, sheet, eventId);
        writeParticipantsListToReport(workbook, sheet, eventId);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.setResponseContentType("application/vnd.ms-excel");
        externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"report.xls\"");

        workbook.write(externalContext.getResponseOutputStream());
        facesContext.responseComplete();
    }
    
    private void writeReportHeader(HSSFWorkbook workbook, HSSFSheet sheet, int eventId) {
        Event event = eventsModel.getEventById(eventId);
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(event.getTitle());
    }
    
    private void writeParticipantsListToReport(HSSFWorkbook workbook, HSSFSheet sheet, int eventId) {
        int currentRow = 5, rowNumeration = 1;
        HSSFRow row = sheet.createRow(currentRow);
        HSSFCell cell = row.createCell(1);
        cell.setCellValue("Lista uczestników:");
        
        List<Participant> eventParticipants = getEventParticipants(eventsModel.getEventById(eventId));
        
        for (Participant participant : eventParticipants) {
            currentRow++;
            row = sheet.createRow(currentRow);
            cell = row.createCell(1);
            cell.setCellValue(rowNumeration);
            cell = row.createCell(2);
            cell.setCellValue(participant.getName());
            cell = row.createCell(3);
            cell.setCellValue(participant.getSurname());
            rowNumeration++;
        }
          
    }
    
    private List<Participant> getEventParticipants(Event event) {
        Collection<ParticipantToEvent> participantToEvent = event.getParticipantToEventCollection();
        List<Participant> participantsOfEvent = new ArrayList<>();
        
        for (ParticipantToEvent entry : participantToEvent) {
            if (entry.getEvent() == event) {
                participantsOfEvent.add(entry.getParticipant());
            }
        }
        
        return participantsOfEvent;      
    }
}
