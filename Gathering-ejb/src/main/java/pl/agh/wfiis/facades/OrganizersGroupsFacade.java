/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.wfiis.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.agh.wfiis.database.OrganizersGroups;

/**
 *
 * @author Patryk
 */
@Stateless
public class OrganizersGroupsFacade extends AbstractFacade<OrganizersGroups> {
    @PersistenceContext(unitName = "pl.agh.wfiis_Gathering-ejb_ejb_devPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrganizersGroupsFacade() {
        super(OrganizersGroups.class);
    }
    
}
