/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Quai;
import entities.Reservation;
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

    @PersistenceContext(unitName = "spacelibPersistenceUnit")
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
        r.setQuaiDepart(quai);
    }

    @Override
    public void quaiArrivee(Reservation r, Quai quai) {
        r.setQuaiArrivee(quai);
    }
    
}
