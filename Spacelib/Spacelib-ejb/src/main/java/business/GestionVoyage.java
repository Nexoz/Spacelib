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
import entities.Usager;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.PasNavetteDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.PasQuaiDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.UsagerInconnuException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.NavetteFacadeLocal;
import repositories.QuaiFacadeLocal;
import repositories.ReservationFacadeLocal;
import repositories.StationFacadeLocal;
import repositories.UsagerFacadeLocal;

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
    
    @EJB
    private UsagerFacadeLocal usagerFacade;
    
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
    public void reserverVoyage(long idStationD, long idStationA, long nbPassager, Date dateA, long idEmprunteur, Date dateOpe) throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException {
        //Tests d'existences
            final Station stationDepart = this.stationFacade.find(idStationD);
            if (stationDepart == null) {
                throw new StationInconnuException();
            }
            final Station stationA = this.stationFacade.find(idStationA);
            if (stationA == null) {
                throw new StationInconnuException();
            }
            final Usager emprunteur = this.usagerFacade.find(idEmprunteur);
            if (emprunteur == null) {
                throw new UsagerInconnuException();
            }
        //Tests de disponiblité de la navette
            List<Quai> listQuais = stationFacade.getQuais(stationDepart);
            Navette navDisponible=null;
            Quai quaiD=null;
            Navette nTempo=null;
            for(Quai q : listQuais ){
                nTempo = q.getNavArrimée();
                if(nTempo!=null && nTempo.getNbPlaces()>=nbPassager && navetteFacade.isDisponible(nTempo)){
                    navDisponible = q.getNavArrimée();
                    quaiD = q;
                }
            }
            if(navDisponible == null){
                throw new PasNavetteDisponibleException();
            }
        //Tests Quais Disponibles dans la station d'arrivée
        //////////////////Ajouter le test de la date
            List<Quai> listQuaisArr = stationFacade.getQuais(stationA);
            Quai quaiA=null;
            for(Quai q : listQuaisArr ){
                if(quaiFacade.isDisponible(q,dateA)){
                    quaiA = q;
                }
            }
            if(quaiA==null){
                throw new PasQuaiDisponibleException();
            }
        //création de la réservation
            final Reservation reservation = this.reservationFacade.creerReservation("voyage initié",quaiD, quaiA, dateA, emprunteur,nbPassager, navDisponible, dateOpe);
            this.usagerFacade.ajouterReservation(emprunteur, reservation);
            this.navetteFacade.ajouterOperation(navDisponible, reservation);
    }

    @Override
    public void demarrerVoyage(long idReservation) throws ReservationInconnuException {
        //idReservation.
    }
    
    
}
