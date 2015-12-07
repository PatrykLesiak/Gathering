package pl.agh.wfiis;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named(value = "userSessionManager")
@SessionScoped
public class UserSessionManager implements Serializable {
    
    @Inject
    private HttpServletRequest request;
    
    public UserSessionManager() {}
    
    public Boolean isUserLoggedin() {
        return isUserInRole("loggedParticipant");
    }
    
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
            return request.isUserInRole("loggedParticipant");
        }

	return false;
    }
    
}
