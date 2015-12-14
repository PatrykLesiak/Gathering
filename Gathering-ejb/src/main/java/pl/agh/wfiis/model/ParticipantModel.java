package pl.agh.wfiis.model;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import pl.agh.wfiis.database.Participant;
import pl.agh.wfiis.facades.ParticipantFacade;

@Stateless
@LocalBean
public class ParticipantModel {
    @EJB 
    ParticipantFacade participantFacade;
    
    public Participant getUserByEmail(String email) {
        List<Participant> participantList = participantFacade.findAll();
        
        for(Participant participant : participantList) {
            if (participant.getEmail().equals(email))
                return participant;
        }
        
        return null;
    }
}
