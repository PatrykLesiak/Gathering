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
        List<ParticipantToEvent> participantToEvent = participantToEventFacade.findAll();
        
        if (participantWithGivenEmail != null) {
            return findParticipantEvents(participantToEvent, participantWithGivenEmail);
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
    
    private Collection<Event> findParticipantEvents(List<ParticipantToEvent>participantToEvent,
                                                    Participant participantWithGivenEmail) {
        Collection<Event> participantEvents =  new ArrayList<>();
        
        for (ParticipantToEvent entry  : participantToEvent) {
            if (participantWithGivenEmail == entry.getParticipant()) {
                participantEvents.add(entry.getEvent());
            }
        }
        
        return participantEvents;
    }
}
