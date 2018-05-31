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
    
    /***
     * Effectue les taches necessaires à l'arrivée d'une navette 
     * @param idNavette identifiant de la navette qui arrive 
     * @param idReservation identifiant du voyage qui se termine
     * @param idQuai identitfiant du quai sur lequel la nevette va s'arrimer
     * @throws NavetteInconnuException
     * @throws ReservationInconnuException
     * @throws QuaiInconnuException 
     */
    @Override
    public void finaliserVoyage(long idNavette, long idReservation, long idQuai) throws NavetteInconnuException, ReservationInconnuException,QuaiInconnuException{
        Navette navette = this.navetteFacade.find(idNavette);
        if (navette == null) {
            throw new NavetteInconnuException();
        }
        Reservation reservation = this.reservationFacade.find(idReservation);
        if (reservation == null) {
            throw new ReservationInconnuException();
        }
        Quai quai = this.quaiFacade.find(idQuai);
        if (quai == null) {
            throw new QuaiInconnuException();
        }
        quaiFacade.arrimer(quai, navette);
        reservationFacade.voyageAchevé(reservation);
        navetteFacade.arrimer(navette, quai);
        navetteFacade.incrementerVoyage(navette);
    }

    /***
     * Enregistre la réservation d'un voyage 
     * @param idStationD identifiant de la station de départ 
     * @param idStationA identifiant de la station d'arrivée
     * @param nbPassager nombre de passagers pour le voyage 
     * @param dateA date d'arrivée 
     * @param idEmprunteur identifiant de l'usager qui réserve le voyage 
     * @param dateOpe date de l'enregistrement de la réservation
     * @throws NavetteInconnuException
     * @throws StationInconnuException
     * @throws PasNavetteDisponibleException
     * @throws PasQuaiDisponibleException
     * @throws UsagerInconnuException 
     */
    @Override
    public void reserverVoyage(long idStationD, long idStationA, long nbPassager, Date dateA, long idEmprunteur, Date dateOpe) throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException {
        //Tests d'existences
            Station stationDepart = this.stationFacade.find(idStationD);
            if (stationDepart == null) {
                throw new StationInconnuException();
            }
            Station stationA = this.stationFacade.find(idStationA);
            if (stationA == null) {
                throw new StationInconnuException();
            }
            Usager emprunteur = this.usagerFacade.find(idEmprunteur);
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
            Reservation reservation = this.reservationFacade.creerReservation("Voyage enregistré",quaiD, quaiA, dateA, emprunteur,nbPassager, navDisponible, dateOpe);
            this.usagerFacade.ajouterReservation(emprunteur, reservation);
            this.navetteFacade.ajouterOperation(navDisponible, reservation);
    }

    /***
     * Initie le départ d'une navette pour un voyage
     * @param idReservation identifiant de la réservation qui débute
     * @throws ReservationInconnuException 
     */
    @Override
    public void demarrerVoyage(long idReservation) throws ReservationInconnuException {
        
        if (reservationFacade.find(idReservation) == null){
            throw new ReservationInconnuException();
        }
        
        
        Reservation resa = reservationFacade.find(idReservation);
        reservationFacade.voyageInitié(resa);
        Navette navette = navetteFacade.find(resa.getNavette());
        Quai quai = quaiFacade.find(navette.getQuaiArrimage());

        navetteFacade.desarrimer(navette);
        quaiFacade.desarrimer(quai);
    }
    
    
}
