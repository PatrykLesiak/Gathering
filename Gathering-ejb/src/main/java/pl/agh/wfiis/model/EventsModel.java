package pl.agh.wfiis.model;

import java.util.ArrayList;
import java.util.List;
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
}
