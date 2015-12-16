package pl.agh.wfiis;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import pl.agh.wfiis.database.Cathegory;
import pl.agh.wfiis.model.CathegoryModel;



@Named(value = "cathegorySelector")
@SessionScoped
public class CathegorySelector implements Serializable{
    
    @EJB
    CathegoryModel cathegoryModel;
    private int currentlySelectedCathegory;

    public int getCurrentlySelectedCathegory() {
        return currentlySelectedCathegory;
    }

    public void setCurrentlySelectedCathegory(int currentlySelectedCathegory) {
        this.currentlySelectedCathegory = currentlySelectedCathegory;
    }
    private Map<String, Integer> availableCathegories;
    
    public CathegorySelector() {
    }
    
    @PostConstruct
    public void init() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map<String, String> urlParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        
        availableCathegories = new LinkedHashMap<>();
        
        for(Cathegory cathegory : cathegoryModel.getAllCathegoriesFromDatabase()) {
                availableCathegories.put(cathegory.getName(), cathegory.getCathegoryid());
        }
    }
    
    public Map<String, Integer> getAvailableCathegories() {
    	return availableCathegories;
    }
    

    
}
