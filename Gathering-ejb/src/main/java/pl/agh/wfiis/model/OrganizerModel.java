package pl.agh.wfiis.model;

import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.database.Organizer;
import pl.agh.wfiis.facades.OrganizerFacade;


@Stateless
@LocalBean
public class OrganizerModel {

    @EJB
    OrganizerFacade organizerFacade;
    
    public Organizer getOrganizerById(int organizerId) {
        return organizerFacade.find(organizerId);
    }
    
    public Organizer getOrganizerByEmail(String email) {
        Collection<Organizer> allOrganizers = organizerFacade.findAll();
        Organizer foundedOrganizer = null;
        
        for (Organizer organizer : allOrganizers) {
            if (organizer.getEmail().equals(email)) {
                foundedOrganizer = organizer;
                break;
            }
        }
        
        return foundedOrganizer;
    }
    
    public Collection<Event> getOrganizerEvent(String organizerEmail) {
        return getOrganizerByEmail(organizerEmail).getEventCollection();
    }

}
