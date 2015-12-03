package pl.agh.wfiis;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.model.EventsModel;


@Named(value = "randomEvents")
@SessionScoped
public class RandomEvents implements Serializable {

    @EJB
    private EventsModel eventsModel;
    
    final int numberOfShownRandomProjects = 5;
    List<Event> listOfRandomEvents;
        
    public RandomEvents() {
    }
    
    public List<Event> getRandomEvents() {
        return eventsModel.getRandomEvents(numberOfShownRandomProjects);
    }
    
}
