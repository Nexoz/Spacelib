/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Reservation;
import entities.Usager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jb
 */
@Stateless
public class UsagerFacade extends AbstractFacade<Usager> implements UsagerFacadeLocal {

    @PersistenceContext(unitName = "spacelibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsagerFacade() {
        super(Usager.class);
    }
    
   /* public Usager nouvelUsager( String nom,String prenom, String login, String password){
        Usager usager = new Usager( nom, prenom,  login,  password);
        this.create(usager);
        return usager;
    }*/

    @Override
    public void ajouterReservation(Usager usager, Reservation r) {
        usager.getListeReservations().add(r);
    }
    
}
