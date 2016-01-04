package pl.agh.wfiis.model;

import java.util.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import pl.agh.wfiis.facades.EventFacade;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.database.Organizer;
import pl.agh.wfiis.facades.OrganizerFacade;
import pl.agh.wfiis.facades.ParticipantFacade;
import pl.agh.wfiis.facades.ParticipantToEventFacade;

@Stateless
@LocalBean
public class EventsModel {
    
    @EJB
    private EventFacade eventFacade;
    
    @EJB
    private OrganizerFacade organizerFacade;
    
    @EJB
    private ParticipantFacade participantFacade;
    
    @EJB
    private ParticipantToEventFacade participantToEventFacade;
    
    public List<Event> getAllEvents() {
        return eventFacade.findAll();
    }

    public List<Event> getRandomEvents(int numberOfShownRandomProjects) {
        List<Event> allEventsFromDatabase = eventFacade.findAll();
        
        if (allEventsFromDatabase.size() < numberOfShownRandomProjects) {
            return allEventsFromDatabase;
        }
        
        List<Event> randomEvents = new ArrayList<>();
        int numberOfProjects = allEventsFromDatabase.size();
        Random randomGenerator = new Random();
        
        for (int i = 0; i < numberOfShownRandomProjects; i++) {
            int randomEventId = randomGenerator.nextInt(numberOfProjects);
            
            while (randomEvents.contains(allEventsFromDatabase.get(randomEventId))) {
                randomEventId = randomGenerator.nextInt(numberOfProjects);
            }
            
            randomEvents.add(allEventsFromDatabase.get(randomEventId));
        }
        
        return randomEvents;
    }

    public Event getEventById(int projectId) {
        return eventFacade.find(projectId);
    }
    
    public Collection<Event> getOrganizerEvents(int organizerId) {
        Organizer organizer = organizerFacade.find(organizerId);
        return organizer.getEventCollection();
    }
    
    public void createEventInDatabase(Event newEvent) {
        eventFacade.create(newEvent);
    }
    
    public Collection<Event> getAllFutureEvents() {
        Collection<Event> events = eventFacade.findAll();
        Iterator<Event> iterator = events.iterator();
        
        while(iterator.hasNext()) {
            if (iterator.next().getEventdate().before(new Date())) {
                iterator.remove();
            }
        }
        return events;
    }
    
    public int getNumberOfParticipantsSignedUpForEvent(int eventId) {  
        return eventFacade.find(eventId).getParticipantToEventCollection().size();
    }
    
    public int getMaxNumberOfParticipantsForEvent(int eventId) {
        return eventFacade.find(eventId).getMaxamountofparticipants();
    }
}
