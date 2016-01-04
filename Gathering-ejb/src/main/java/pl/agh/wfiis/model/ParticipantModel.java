package pl.agh.wfiis.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.database.Participant;
import pl.agh.wfiis.database.ParticipantToEvent;
import pl.agh.wfiis.facades.EventFacade;
import pl.agh.wfiis.facades.ParticipantFacade;
import pl.agh.wfiis.facades.ParticipantToEventFacade;

@Stateless
@LocalBean
public class ParticipantModel {
    @EJB
    EventFacade eventFacade;
    
    @EJB 
    ParticipantFacade participantFacade;
    
    @EJB
    ParticipantToEventFacade participantToEventFacade;
    
    public Participant getUserByEmail(String email) {
        List<Participant> participantList = participantFacade.findAll();
        
        for(Participant participant : participantList) {
            if (participant.getEmail().equals(email))
                return participant;
        }
        
        return null;
    }
    
    public Collection<Event> getParticiantEventsByEmai(String email) {
        Participant participantWithGivenEmail = getParticipantWithGivenEmail(email);
        
        if (participantWithGivenEmail != null) {
            return findParticipantEvents(participantWithGivenEmail);
        }
        else {
            return null;
        }
    }
    
    private Participant getParticipantWithGivenEmail(String email) {
        Collection<Participant> allParticipants = participantFacade.findAll();
        
        for (Participant participant : allParticipants) {
            if (participant.getEmail().equals(email)) {
                return participant;
            }
        }
        
        return null;
    }
            
    private Collection<Event> findParticipantEvents(Participant participant) {
        List<ParticipantToEvent> participantToEvent = participantToEventFacade.findAll();
        Collection<Event> participantEvents = new ArrayList<>();
        
        for (ParticipantToEvent entry  : participantToEvent) {
            if (participant == entry.getParticipant()) {
                participantEvents.add(entry.getEvent());
            }
        }
        
        return participantEvents;
    }
    
    public Boolean isParticipantSignedUpForEvent(int eventId, String participantEmail) {
        Participant participant = getUserByEmail(participantEmail);
        Collection<ParticipantToEvent> participantToEvents = eventFacade.find(eventId).getParticipantToEventCollection();
        
        for (ParticipantToEvent entry : participantToEvents) {
            if (entry.getParticipant().equals(participant)) {
                return true;
            }
        }
        return false;
    }
    
    public void signUpParticipantToEvent(int eventId, String participantEmail) {
        ParticipantToEvent newEntry = new ParticipantToEvent();
        newEntry.setEvent(eventFacade.find(eventId));
        newEntry.setParticipant(getUserByEmail(participantEmail));

        participantToEventFacade.create(newEntry);
    }
}
