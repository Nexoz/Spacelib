/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.business;

import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Reservation;
import fr.miage.toulouse.entities.Station;
import fr.miage.toulouse.entities.Usager;
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
import fr.miage.toulouse.repositories.OperationFacadeLocal;
import fr.miage.toulouse.repositories.NavetteFacadeLocal;
import fr.miage.toulouse.repositories.QuaiFacadeLocal;
import fr.miage.toulouse.repositories.ReservationFacadeLocal;
import fr.miage.toulouse.repositories.StationFacadeLocal;
import fr.miage.toulouse.repositories.UsagerFacadeLocal;
import fr.miage.toulouse.spacelibshared.DistancesCalculator;
import java.util.ArrayList;
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
    
    @EJB
    private OperationFacadeLocal operationFacade;
    
    /***
     * Effectue les taches necessaires à l'arrivée d'une navette 
     * @param idReservation identifiant du voyage qui se termine
     * @throws NavetteInconnuException
     * @throws ReservationInconnuException
     * @throws QuaiInconnuException 
     */
    @Override
    public void finaliserVoyage( long idReservation) throws NavetteInconnuException, ReservationInconnuException,QuaiInconnuException{
        Reservation reservation = this.reservationFacade.find(idReservation);
        if (reservation == null) {
            throw new ReservationInconnuException();
        }
        /*Navette navette = this.navetteFacade.find(idNavette);
        if (navette == null) {
            throw new NavetteInconnuException();
        }
        Quai quai = this.quaiFacade.find(idQuai);
        if (quai == null) {
            throw new QuaiInconnuException();
        }*/
        Quai quai = reservation.getQuaiArrivee();
        Navette navette = reservation.getNavette();
        quaiFacade.arrimer(quai, navette);
        reservationFacade.voyageAchevé(reservation);
        navetteFacade.arrimer(navette, quai);
        navetteFacade.incrementerVoyage(navette);
        
        if(navette.getProchaineRevision()==0){
            navetteFacade.ajouterOperation(navette, operationFacade.creerOperation("Révision nécessaire", quai, navette));
        }
        
    }

    /***
     * Enregistre la réservation d'un voyage 
     * @param idStationD identifiant de la station de départ 
     * @param idStationA identifiant de la station d'arrivée
     * @param nbPassager nombre de passagers pour le voyage 
     * @param idEmprunteur identifiant de l'usager qui réserve le voyage 
     * @param dateOpe date de l'enregistrement de la réservation
     * @throws NavetteInconnuException
     * @throws StationInconnuException
     * @throws PasNavetteDisponibleException
     * @throws PasQuaiDisponibleException
     * @throws UsagerInconnuException 
     */
    @Override
    public long reserverVoyage(long idStationD, long idStationA, int nbPassager, long idEmprunteur, Date dateOpe) throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException {
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
            List<Quai> listQuaisArr = stationFacade.getQuais(stationA);
            Quai quaiA=null;
            for(Quai q : listQuaisArr ){
                if(quaiFacade.isDisponible(q)){
                    quaiA = q;
                }
            }
            if(quaiA==null){
                throw new PasQuaiDisponibleException();
            }
        //création de la réservation
            Reservation reservation = this.reservationFacade.creerReservation("Voyage enregistré",quaiD, quaiA, emprunteur,nbPassager, navDisponible, dateOpe);
            this.usagerFacade.ajouterReservation(emprunteur, reservation);
            this.navetteFacade.ajouterOperation(navDisponible, reservation);
            Date dateA = new Date();
            dateA.setDate(dateOpe.getDate()+DistancesCalculator.getInstance().calculerDistance(stationA.getNom(),stationDepart.getNom()));
            this.quaiFacade.reserverQuai(quaiA,dateA);
            
        return reservation.getId();
    }

    /***
     * Initie le départ d'une navette pour un voyage
     * @param idReservation identifiant de la réservation qui débute
     * @throws ReservationInconnuException 
     */
    @Override
    public void demarrerVoyage(long idReservation) throws ReservationInconnuException {
        final Reservation reserv = this.reservationFacade.find(idReservation);
        if (reserv == null) {
            throw new ReservationInconnuException();
        }
        Navette navette = navetteFacade.find(reserv.getNavette().getId());
        navetteFacade.desarrimer(navette);
        Quai quai = quaiFacade.find(reserv.getQuaiOperation().getId());
        quaiFacade.desarrimer(quai);
        reservationFacade.voyageInitié(reserv);
    }

    /**
     * Permet de calculer la distance en jours entre deux stations
     * Il est obligatoire de passer des noms en paramètre car nous connaissons uniquement la distance entre 2 stations grâce à leur nom
     * @param nomStationD Nom de la station de départ
     * @param nomStationA Nom de la station d'arrivée
     * @return Nombre de jours nécessaires
     */
    @Override
    public Integer calculerDistance(String nomStationD, String nomStationA) {
        return DistancesCalculator.getInstance().calculerDistance(nomStationD, nomStationA);
    }

    @Override
    public Reservation derniereReservation(long idUsager) throws UsagerInconnuException{
        Usager usager = this.usagerFacade.find(idUsager);
            if (usager == null) {
                throw new UsagerInconnuException();
            }
        List<Reservation> listR = new ArrayList<Reservation>();
        listR = usagerFacade.reservationsUsager(usager);
        if(listR.size()>=1){
            for(Reservation r : listR){
                if(r.getDateFin()==null){
                    return r;
                }
            }
            return null;
        }
        return null;
    }

    @Override
    public String quaiReservation(long idReservation) throws ReservationInconnuException {
        final Reservation reserv = this.reservationFacade.find(idReservation);
        if (reserv == null) {
            throw new ReservationInconnuException();
        }
        return reserv.getQuaiOperation().getCodeQuai();
    }
    
    
    
    
}
