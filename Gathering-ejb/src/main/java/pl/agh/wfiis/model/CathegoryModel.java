package pl.agh.wfiis.model;

import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import pl.agh.wfiis.database.Cathegory;
import pl.agh.wfiis.facades.CathegoryFacade;

@Stateless
@LocalBean
public class CathegoryModel {

        @EJB
        CathegoryFacade cathegoryFacade;
        
        public Collection<Cathegory> getAllCathegoriesFromDatabase() {
            return cathegoryFacade.findAll();
        }
        
        public Cathegory getCathegoryById(int id) {
            return cathegoryFacade.find(id);
        }
}
