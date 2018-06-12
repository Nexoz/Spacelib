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

    public Utilisateur authentifier(String login, String password);
    public Integer calculerDistance(String nomStationD, String nomStationA);
    long creerUsager(String nom, String prenom, String login, String password) throws LoginUsedException;
    long reserverVoyage (long idStationD, long idStationA, int nbPassager, long idEmprunteur, Date dateOpe, Date dateDebut) throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException;
    List<Reservation> getReservationsForUsager(long idUsager) throws UsagerInconnuException;
    void annulerReservation(long idReservation) throws ReservationInconnuException;
    
}
