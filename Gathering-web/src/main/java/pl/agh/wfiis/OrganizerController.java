package pl.agh.wfiis;

import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.database.Organizer;
import pl.agh.wfiis.model.OrganizerModel;

@Named(value = "organizerController")
@SessionScoped
public class OrganizerController implements Serializable {

    @EJB
    OrganizerModel organizerModel;
    
    public OrganizerController() {
    }
    
    public Organizer getOrganizerById(int organizerId) {
        return organizerModel.getOrganizerById(organizerId);
    }
    
    public Collection<Event> getOrganizerEvent(String organizerEmail) {
        return organizerModel.getOrganizerEvent(organizerEmail);
    }
}
