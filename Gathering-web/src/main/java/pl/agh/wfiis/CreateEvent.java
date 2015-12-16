package pl.agh.wfiis;

import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import pl.agh.wfiis.database.Cathegory;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.database.Organizer;
import pl.agh.wfiis.model.CathegoryModel;
import pl.agh.wfiis.model.EventsModel;
import pl.agh.wfiis.model.OrganizerModel;

@Named(value = "createEvent")
@SessionScoped
public class CreateEvent implements Serializable {

    private String title;
    private String description;
    private Date eventData;
    private String place;
    private String pictureLink;
    private int maxAmountOfParticipants;
    private double price;
    private String currency = "PLN";
    private int minimalAge;
    private int maximalAge;
    
    @Inject
    CathegorySelector cathegorySelector;
    
    @Inject
    private HttpServletRequest request;
    
    @EJB
    OrganizerModel organizerModel;
    
    @EJB
    CathegoryModel cathegorymodel;
    
    @EJB
    EventsModel eventsModel;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventData() {
        return eventData;
    }

    public void setEventData(Date eventData) {
        this.eventData = eventData;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public int getMaxAmountOfParticipants() {
        return maxAmountOfParticipants;
    }

    public void setMaxAmountOfParticipants(int maxAmountOfParticipants) {
        this.maxAmountOfParticipants = maxAmountOfParticipants;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public int getMaximalAge() {
        return maximalAge;
    }

    public void setMaximalAge(int maximalAge) {
        this.maximalAge = maximalAge;
    }
    
    public CreateEvent() {
    }
    
    public String registerNewEventInDatabase() {
        Organizer organizer = organizerModel.getOrganizerByEmail(request.getUserPrincipal().getName());
        Cathegory cathegory = cathegorymodel.getCathegoryById(cathegorySelector.getCurrentlySelectedCathegory());
        eventsModel.createEventInDatabase(createEvent(organizer, cathegory));
        return "/index";
    }
    
    private Event createEvent(Organizer organizer, Cathegory cathegory) {      
        Event newEvent = new Event();
        newEvent.setTitle(title);
        newEvent.setDescription(description);
        newEvent.setEventdate(eventData);
        newEvent.setPlace(place);
        newEvent.setPicturelink(pictureLink);
        newEvent.setMaxamountofparticipants(maxAmountOfParticipants);
        newEvent.setPrice(price);
        newEvent.setCurrency(currency);
        newEvent.setMinimalage(minimalAge);
        newEvent.setMaximalage(maximalAge);
        newEvent.setCathegory(cathegory);
        newEvent.setOrganizer(organizer);
        
        return newEvent;
    }
    
}
