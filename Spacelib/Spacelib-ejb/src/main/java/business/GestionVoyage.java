/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Navette;
import entities.Quai;
import entities.Reservation;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.NavetteFacade;
import repositories.QuaiFacade;
import repositories.ReservationFacade;

/**
 *
 * @author jb
 */
@Stateless
public class GestionVoyage implements GestionVoyageLocal {

    @EJB
    private ReservationFacade reservationFacade;
    
    @EJB
    private NavetteFacade navetteFacade;
    
    @EJB
    private QuaiFacade quaiFacade;
    
    @Override
    public void finaliserVoyage(Navette navette, Reservation reservation, Quai quai) {
        quaiFacade.arrimer(quai, navette);
        reservationFacade.voyageAchevé(reservation);
        navetteFacade.arrimer(navette, quai);
        navetteFacade.incrementerVoyage(navette);
    }

    @Override
    public void reserverNavette(Navette navette, Reservation reservation, Quai quaiDepart) {
        reservationFacade.quaiDepart(reservation, quaiDepart);
        reservationFacade.voyageInitié(reservation);
        navetteFacade.ajouterOperation(navette, reservation);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
