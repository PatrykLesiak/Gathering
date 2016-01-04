package pl.agh.wfiis;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.model.EventsModel;
import pl.agh.wfiis.model.ParticipantModel;

@Named(value = "eventController")
@SessionScoped
public class EventController implements Serializable {
Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private HttpServletRequest request;
    
    @EJB
    private EventsModel eventsModel;
    
    @EJB
    ParticipantModel participantModel;
    
    final int numberOfShownRandomProjects = 3;
    List<Event> listOfRandomEvents;
        
    public EventController() {
    }
    
    public List<Event> getRandomEvents() {
        return eventsModel.getRandomEvents(numberOfShownRandomProjects);
    }
    
    public Event getEventById(int projectId) {
        return eventsModel.getEventById(projectId);
    }
    
    public Collection<Event> getOrganizerEvents(int organizerId) {
       return eventsModel.getOrganizerEvents(organizerId);
    }
    
    public Collection<Event> getAllFutureEvents() {
        return eventsModel.getAllFutureEvents();
    }
    
    public Boolean canParticipantSignUpForEvent(int eventId) {
        Boolean avaiblePlaces = eventsModel.getMaxNumberOfParticipantsForEvent(eventId)
                                    > eventsModel.getNumberOfParticipantsSignedUpForEvent(eventId);
        
        Boolean isParticipantAlreadySignedUp = participantModel.isParticipantSignedUpForEvent(
                                                   eventId, request.getUserPrincipal().getName());
        
        return avaiblePlaces && !isParticipantAlreadySignedUp;
    }
    
    public void signUpLoggedParticipantToEvent(int eventId) {
        participantModel.signUpParticipantToEvent(eventId, request.getUserPrincipal().getName());
    }
}
