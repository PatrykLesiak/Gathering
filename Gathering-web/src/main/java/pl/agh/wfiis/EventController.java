package pl.agh.wfiis;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.model.EventsModel;


@Named(value = "eventController")
@SessionScoped
public class EventController implements Serializable {

    @EJB
    private EventsModel eventsModel;
     
    
    public EventController() {
    }
    
    public String getEventTitle() {
        List<Event> eventList = eventsModel.getAllEvents();
        return eventList.get(0).getTitle();
    }
    
}
