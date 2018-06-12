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
    
    
    @Override
    public void finaliserVoyage( long idReservation) throws ReservationInconnuException{
        Reservation reservation = this.reservationFacade.find(idReservation);
        if (reservation == null) {
            throw new ReservationInconnuException();
        }
        Quai quaiD = reservation.getQuaiOperation();
        if(quaiD.getNavArrimée() == reservation.getNavette()) {
            quaiFacade.desarrimer(quaiD);
        }
        Quai quai = reservation.getQuaiArrivee();
        Navette navette = reservation.getNavette();
        quaiFacade.arrimer(quai, navette);
        reservationFacade.voyageAchevé(reservation);
        navetteFacade.arrimer(navette, quai);
        navetteFacade.incrementerVoyage(navette);
        
        if(navette.getProchaineRevision()==3){
            navetteFacade.ajouterOperation(navette, operationFacade.creerOperation("Révision nécessaire", quai, navette));
        }
        
    }

    
    @Override
    public long reserverVoyage(long idStationD, long idStationA, int nbPassager, long idEmprunteur, Date dateOpe, Date dateDebut) throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException {
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
                if(nTempo!=null) {
                    if(nTempo.getNbPlaces()>=nbPassager && navetteFacade.isDisponible(nTempo)){
                        navDisponible = q.getNavArrimée();
                        quaiD = q;
                    }
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
            Reservation reservation = this.reservationFacade.creerReservation("Voyage enregistré",quaiD, quaiA, emprunteur,nbPassager, navDisponible, dateOpe, dateDebut);
            this.usagerFacade.ajouterReservation(emprunteur, reservation);
            this.navetteFacade.ajouterOperation(navDisponible, reservation);
            Date dateA = new Date();
            dateA.setDate(dateOpe.getDate()+DistancesCalculator.getInstance().calculerDistance(stationA.getNom(),stationDepart.getNom()));
            this.quaiFacade.reserverQuai(quaiA,dateA);
            
        return reservation.getId();
    }

    
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
    
    @Override
    public List<Reservation> getReservationsForUsager(long idUsager) throws UsagerInconnuException {
        Usager usager = this.usagerFacade.find(idUsager);
        if (usager == null) {
            throw new UsagerInconnuException();
        }
        return usagerFacade.reservationsUsager(usager);
    }
    
    @Override
    public void annulerReservation(long idReservation) throws ReservationInconnuException {
        Reservation r = reservationFacade.find(idReservation);
        if (r == null) {
            throw new ReservationInconnuException();
        }
        Usager u = r.getEmprunteur();
        Quai q = r.getQuaiArrivee();
        reservationFacade.remove(r);
        usagerFacade.edit(u);
        q.setDateReservation(null);
        quaiFacade.edit(q);
        
    }
    
    
    
    
}
