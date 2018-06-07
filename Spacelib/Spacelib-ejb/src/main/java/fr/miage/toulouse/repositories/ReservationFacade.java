/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Reservation;
import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Reservation;
import fr.miage.toulouse.entities.Usager;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author jb
 */
@Stateless
public class ReservationFacade extends AbstractFacade<Reservation> implements ReservationFacadeLocal {

    @PersistenceContext(unitName = "connectionPoolSpacelib")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservationFacade() {
        super(Reservation.class);
    }

    /**
     * Marque la fin d'un voyage
     * @param r Réservation conercnée
     */
    @Override
    public void voyageAchevé(Reservation r) {
        r.setDateFin(new Date());
        r.setLibelle("Voyage achevé");
    }

    /**
     * Marque le début d'un voyage
     * @param r Réservation conercnée
     */
    @Override
    public void voyageInitié(Reservation r) {
        r.setDateDebut(new Date());
    }

    @Override
    public void quaiDepart(Reservation r,Quai quai) {
        r.setQuaiOperation(quai);
    }

    @Override
    public void quaiArrivee(Reservation r, Quai quai) {
        r.setQuaiArrivee(quai);
    }
    
    @Override
    public Reservation creerReservation(String texte, Quai quaiD, Quai quaiA, Usager emprunteur, int nbPassager, Navette navDisponible,Date dateOpe) {
        Reservation c = new Reservation( texte,  quaiD,  quaiA,  emprunteur,  nbPassager,  navDisponible, dateOpe);
        this.create(c);
        return c;
    }

    
}
