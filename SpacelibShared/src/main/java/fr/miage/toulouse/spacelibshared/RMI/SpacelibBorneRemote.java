/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.spacelibshared.RMI;

import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import fr.miage.toulouse.spacelibshared.admin.ObjUsager;
import fr.miage.toulouse.spacelibshared.exceptions.LoginUsedException;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.PasNavetteDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.PasQuaiDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.UsagerInconnuException;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 * Interface du service de la Borne
 * @author pierreliaubet
 */
@Remote
public interface SpacelibBorneRemote {
    /**
     * Permet de cloturer un voyage
     * @param idReservation id de la réservation
     * @throws NavetteInconnuException
     * @throws ReservationInconnuException
     * @throws QuaiInconnuException 
     */
    void finaliserVoyage(long idReservation) throws ReservationInconnuException;
    
    /**
     * Permet de réserver une navette
     * @param idStationD id de la station de départ du voyage
     * @param idStationA id de la station d'arrivée du voyage
     * @param nbPassager nombre de passager du voyage
     * @param idEmprunteur id de la personne voulant réserver la navette
     * @param dateOpe date de la demande de réservation
     * @return
     * @throws NavetteInconnuException
     * @throws StationInconnuException
     * @throws PasNavetteDisponibleException
     * @throws PasQuaiDisponibleException
     * @throws UsagerInconnuException 
     */
    long reserverVoyage (long idStationD, long idStationA, int nbPassager, long idEmprunteur,Date dateOpe)throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException;
    
    /**
     * Permet de démarrer un voyage
     * @param idReservation id de la réservation à démarrer
     * @throws ReservationInconnuException 
     */
    void demarrerVoyage (long idReservation)throws ReservationInconnuException;
    
    /**
     * Renvoie toutes les stations du SI
     * @return List<ObjStation>
     */
    List<ObjStation> consulterStation() ;
    
    
    /**
     * Permet de s'authentifier
     * @param login login de l'usager
     * @param password mot ed passe de l'usager
     * @return l'usager qui s'est connecté
     * @throws UsagerInconnuException 
     */
    ObjUsager authentifier(String login, String password) throws UsagerInconnuException;
    
    /**
     * Permet de créer un usager
     * @param nom nom de la personne
     * @param prenom prénom de la personne
     * @param login indetifiant de connection
     * @param password mot de passe du compte
     * @return id de la personne créée
     * @throws LoginUsedException 
     */
    long creerUsager(String nom, String prenom, String login, String password) throws LoginUsedException;
    
    /**
     * Renvoie l'identifiant de la dernière réservation d'un usager
     * @param idUsager id de l'usager
     * @return id de la réservation
     * @throws UsagerInconnuException 
     */
    Long derniereReservation(long idUsager) throws UsagerInconnuException;
    
    /**
     * Renvoie le nom du quai où l'usager doit se rendre pour emprunter la navette
     * @param idReservation id de la réservation de l'usager
     * @return CodeQuai le nom du quai
     * @throws ReservationInconnuException 
     */
    String quaiReservation(long idReservation) throws ReservationInconnuException;
    
}
