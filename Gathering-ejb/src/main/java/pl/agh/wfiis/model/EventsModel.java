package pl.agh.wfiis.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import pl.agh.wfiis.facades.EventFacade;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.database.Organizer;
import pl.agh.wfiis.facades.OrganizerFacade;

@Stateless
@LocalBean
public class EventsModel {
    
    @EJB
    private EventFacade eventFacade;
    
    @EJB
    private OrganizerFacade organizerFacade;
    
    public List<Event> getAllEvents() {
        List<Event> list = new ArrayList();
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
}
