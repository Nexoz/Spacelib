/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.business;

import fr.miage.toulouse.entities.Reservation;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.PasNavetteDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.PasQuaiDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.UsagerInconnuException;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 * Interface de gestion des voyages
 * @author jb
 */
@Local
public interface GestionVoyageLocal {
    
    /***
     * Effectue les taches necessaires à l'arrivée d'une navette 
     * @param idReservation identifiant du voyage qui se termine
     * @throws NavetteInconnuException
     * @throws ReservationInconnuException
     * @throws QuaiInconnuException 
     */
    void finaliserVoyage(long idReservation) throws ReservationInconnuException;

    
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
    long reserverVoyage (long idStationD, long idStationA, int nbPassager, long idEmprunteur,Date dateOpe, Date dateDebut)throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException;
    
    /***
     * Initie le départ d'une navette pour un voyage
     * @param idReservation identifiant de la réservation qui débute
     * @throws ReservationInconnuException 
     */
    void demarrerVoyage (long idReservation)throws ReservationInconnuException;
    
    /**
     * Permet de calculer la distance en jours entre deux stations
     * Il est obligatoire de passer des noms en paramètre car nous connaissons uniquement la distance entre 2 stations grâce à leur nom
     * @param nomStationD Nom de la station de départ
     * @param nomStationA Nom de la station d'arrivée
     * @return Nombre de jours nécessaires
     */
    Integer calculerDistance(String nomStationD, String nomStationA);
    
    /**
     * Renvoie la dernière réservation d'un usager
     * @param idUsager id de l'usager
     * @return Reservation
     * @throws UsagerInconnuException 
     */
    Reservation derniereReservation(long idUsager) throws UsagerInconnuException;
    
    /**
     * Renvoie le nom du quai de départ d'une réservation
     * @param idReservation id de la réservation
     * @return Nom du quai
     * @throws ReservationInconnuException 
     */
    String quaiReservation(long idReservation) throws ReservationInconnuException;
    
    /**
     * Retourne la liste des différents voyages qu'un usager a effectué
     * @param idUsager Usager en question
     * @return La liste de ses voyages
     * @throws UsagerInconnuException 
     */
    List<Reservation> getReservationsForUsager(long idUsager) throws UsagerInconnuException;
    
    /**
     * Annule et supprime la réservation identifiée en paramètre
     * @param idReservation
     * @throws ReservationInconnuException 
     */
    void annulerReservation(long idReservation) throws ReservationInconnuException;
}
