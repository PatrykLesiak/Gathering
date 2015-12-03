package pl.agh.wfiis;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.model.EventsModel;


@Named(value = "eventController")
@SessionScoped
public class EventController implements Serializable {

    @EJB
    private EventsModel eventsModel;
    
    final int numberOfShownRandomProjects = 3;
    List<Event> listOfRandomEvents;
        
    public EventController() {
    }
    
    public List<Event> getRandomEvents() {
        return eventsModel.getRandomEvents(numberOfShownRandomProjects);
    }
    
}
