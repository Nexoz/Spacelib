/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Usager;
import fr.miage.toulouse.entities.Reservation;
import fr.miage.toulouse.entities.Usager;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jb
 */
@Stateless
public class UsagerFacade extends AbstractFacade<Usager> implements UsagerFacadeLocal {

    @PersistenceContext(unitName = "connectionPoolSpacelib")
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
