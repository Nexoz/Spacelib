/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.entities.Reservation;
import fr.miage.toulouse.entities.Utilisateur;
import fr.miage.toulouse.spacelibshared.exceptions.LoginUsedException;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.PasNavetteDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.PasQuaiDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.UsagerInconnuException;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface ServiceReservationUsagerLocal {

    /**
     * Authentifie un Usager
     * @param login
     * @param password
     * @return 
     */
    public Utilisateur authentifier(String login, String password);
    
    /** 
     * Calcule la distance en nombre de jours entre 2 stations
     * @param nomStationD
     * @param nomStationA
     * @return 
     */
    public Integer calculerDistance(String nomStationD, String nomStationA);
    
    /**
     * Créé un nouvel usager
     * @param nom
     * @param prenom
     * @param login
     * @param password
     * @return son id
     * @throws LoginUsedException 
     */
    long creerUsager(String nom, String prenom, String login, String password) throws LoginUsedException;
    
    /**
     * Réservation d'un nouveau voyage
     * @param idStationD id Station Départ
     * @param idStationA id Station Arrivée
     * @param nbPassager 
     * @param idEmprunteur id de l'usager
     * @param dateOpe date de la création de la réservation
     * @param dateDebut date du vol
     * @return L'id de la réservation
     * @throws NavetteInconnuException
     * @throws StationInconnuException
     * @throws PasNavetteDisponibleException
     * @throws PasQuaiDisponibleException
     * @throws UsagerInconnuException 
     */
    long reserverVoyage (long idStationD, long idStationA, int nbPassager, long idEmprunteur, Date dateOpe, Date dateDebut) throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException;
    
    /**
     * Retourne l'historiques des vols pour un usager
     * @param idUsager
     * @return
     * @throws UsagerInconnuException 
     */
    List<Reservation> getReservationsForUsager(long idUsager) throws UsagerInconnuException;
    
    /**
     * Annule une réservation
     * @param idReservation
     * @throws ReservationInconnuException 
     */
    void annulerReservation(long idReservation) throws ReservationInconnuException;
    
}
