package pl.agh.wfiis;

import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.model.ParticipantModel;

@Named(value = "participantController")
@Dependent
public class ParticipantController {

    @EJB
    ParticipantModel participantModel;
    
    public ParticipantController() {
    }
    
    public Collection<Event> getParticipantEvents(String email) {
        return participantModel.getParticiantEventsByEmai(email) ;
    }
    
}
