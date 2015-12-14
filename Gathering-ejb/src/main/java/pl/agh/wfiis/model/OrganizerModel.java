package pl.agh.wfiis.model;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
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
}
