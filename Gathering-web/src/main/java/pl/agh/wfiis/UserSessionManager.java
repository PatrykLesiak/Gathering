package pl.agh.wfiis;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import pl.agh.wfiis.database.Participant;
import pl.agh.wfiis.model.ParticipantModel;

@Named(value = "userSessionManager")
@SessionScoped
public class UserSessionManager implements Serializable {
    
    @EJB
    ParticipantModel participantModel;
    
    @Inject
    private HttpServletRequest request;
    
    public UserSessionManager() {}
    
    public void logOut() {
	HttpSession session = getHttpSession();
	session.invalidate();
    }
    
    private HttpSession getHttpSession() {
	FacesContext facesContext = FacesContext.getCurrentInstance();
	return (HttpSession) facesContext.getExternalContext().getSession(false);
    }    
    
    public boolean isUserInRole(String roleName) {
        if(request.getUserPrincipal() != null) {
            return request.isUserInRole(roleName);
        }

	return false;
    }
    
    public int getUserId() {
        Participant participant = participantModel.getUserByEmail(request.getUserPrincipal().getName());
        return participant.getParticipantid();
    }
}
