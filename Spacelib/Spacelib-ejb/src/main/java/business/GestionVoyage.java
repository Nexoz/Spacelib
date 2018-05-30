/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Navette;
import entities.Quai;
import entities.Reservation;
import entities.Station;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.PasNavetteDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.PasQuaiDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.NavetteFacadeLocal;
import repositories.QuaiFacadeLocal;
import repositories.ReservationFacadeLocal;
import repositories.StationFacadeLocal;

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
   
    @EJB
    private StationFacadeLocal stationFacade;
    
    
    @Override
    public void finaliserVoyage(long idNavette, long idReservation, long idQuai) throws NavetteInconnuException, ReservationInconnuException,QuaiInconnuException{
        final Navette navette = this.navetteFacade.find(idNavette);
        if (navette == null) {
            throw new NavetteInconnuException();
        }
        final Reservation reservation = this.reservationFacade.find(idReservation);
        if (reservation == null) {
            throw new ReservationInconnuException();
        }
        final Quai quai = this.quaiFacade.find(idQuai);
        if (quai == null) {
            throw new QuaiInconnuException();
        }
        quaiFacade.arrimer(quai, navette);
        reservationFacade.voyageAchevé(reservation);
        navetteFacade.arrimer(navette, quai);
        navetteFacade.incrementerVoyage(navette);
    }

    @Override
    public void reserverNavette(long idNavette, long idQuaiDepart, long idQuaiArrive) throws NavetteInconnuException,QuaiInconnuException{
        final Navette navette = this.navetteFacade.find(idNavette);
        if (navette == null) {
            throw new NavetteInconnuException();
        }
        final Quai quaiDepart = this.quaiFacade.find(idQuaiDepart);
        if (quaiDepart == null) {
            throw new QuaiInconnuException();
        }
        final Quai quaiArrive = this.quaiFacade.find(idQuaiArrive);
        if (quaiArrive == null) {
            throw new QuaiInconnuException();
        }
        final Reservation reservation = this.reservationFacade.creerReservation(quaiDepart, quaiArrive);
        reservationFacade.quaiDepart(reservation, quaiDepart);
        reservationFacade.voyageInitié(reservation);
        navetteFacade.ajouterOperation(navette, reservation);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void realiserVoyage(long idStationD, long idStationA, long nbPassager, Date dateA) throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException {
        //Tests d'existences
            final Station stationDepart = this.stationFacade.find(idStationD);
            if (stationDepart == null) {
                throw new StationInconnuException();
            }
            final Station stationA = this.stationFacade.find(idStationA);
            if (stationA == null) {
                throw new StationInconnuException();
            }
        //Tests de disponiblité de la navette
            List<Quai> listQuais = stationFacade.getQuais(stationDepart);
            Navette navDisponible=null;
            long quaiD=0;
            Navette nTempo=null;
            for(Quai q : listQuais ){
                nTempo = q.getNavArrimée();
                if(nTempo!=null && nTempo.getNbPlaces()>=nbPassager && navetteFacade.isDisponible(nTempo)){
                    navDisponible = q.getNavArrimée();
                    quaiD = q.getId();
                }
            }
            if(navDisponible == null){
                throw new PasNavetteDisponibleException();
            }
        //Tests Quais Disponibles dans la station d'arrivée
        //////////////////Ajouter le test de la date
            List<Quai> listQuaisArr = stationFacade.getQuais(stationA);
            long quaiA=0;
            for(Quai q : listQuaisArr ){
                if(quaiFacade.isDisponible(q,dateA)){
                    quaiA = q.getId();
                }
            }
            if(quaiA==0){
                throw new PasQuaiDisponibleException();
            }
        //création de la réservation
        //final Reservation reservation = this.reservationFacade.creerReservation(quaiD, quaiA);
    }
}
