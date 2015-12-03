package pl.agh.wfiis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import pl.agh.wfiis.facades.EventFacade;
import pl.agh.wfiis.database.Event;

@Stateless
@LocalBean
public class EventsModel {
    
    @EJB
    private EventFacade eventFacade;
    
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
            int randomEventId = randomGenerator.nextInt(numberOfProjects) + 1;
            
            while (randomEvents.contains(allEventsFromDatabase.get(randomEventId))) {
                randomEventId = randomGenerator.nextInt(numberOfProjects) + 1;
            }
            
            randomEvents.add(allEventsFromDatabase.get(randomEventId));
        }
        
        return randomEvents;
    }
}
