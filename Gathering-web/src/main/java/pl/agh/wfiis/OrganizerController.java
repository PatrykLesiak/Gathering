package pl.agh.wfiis;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.database.Organizer;
import pl.agh.wfiis.model.OrganizerModel;


@Named(value = "organizerController")
@Dependent
public class OrganizerController {

    @EJB
    OrganizerModel organizerModel;
    
    public OrganizerController() {
    }
    
    public Organizer getOrganizerById(int organizerId) {
        return organizerModel.getOrganizerById(organizerId);
    }
    
}
