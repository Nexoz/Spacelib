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
import repositories.NavetteFacadeLocal;
import repositories.QuaiFacadeLocal;
import repositories.ReservationFacadeLocal;

/**
 *
 * @author jb
 */
@Stateless
public class GestionVoyage implements GestionVoyageLocal {

    @EJB
    private ReservationFacadeLocal reservationFacade;
    
    @EJB
    private NavetteFacadeLocal navetteFacade;
    
    @EJB
    private QuaiFacadeLocal quaiFacade;
    
    @Override
    public void finaliserVoyage(long idNavette, long idReservation, long idQuai) {
        final Navette navette = this.navetteFacade.find(idNavette);
        final Reservation reservation = this.reservationFacade.find(idReservation);
        final Quai quai = this.quaiFacade.find(idQuai);
        if(navette !=null && reservation !=null && quai !=null){
            quaiFacade.arrimer(quai, navette);
            reservationFacade.voyageAchevé(reservation);
            navetteFacade.arrimer(navette, quai);
            navetteFacade.incrementerVoyage(navette);
        }
    }

    @Override
    public void reserverNavette(long idNavette, long idReservation, long idQuaiDepart) {
        final Navette navette = this.navetteFacade.find(idNavette);
        final Reservation reservation = this.reservationFacade.find(idReservation);
        final Quai quaiDepart = this.quaiFacade.find(idQuaiDepart);
        if(navette !=null && reservation !=null && quaiDepart !=null){
            reservationFacade.quaiDepart(reservation, quaiDepart);
            reservationFacade.voyageInitié(reservation);
            navetteFacade.ajouterOperation(navette, reservation);
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
