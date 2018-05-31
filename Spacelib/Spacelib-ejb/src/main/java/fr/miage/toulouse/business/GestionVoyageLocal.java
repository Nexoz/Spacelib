/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.business;

import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.PasNavetteDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.PasQuaiDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.UsagerInconnuException;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface GestionVoyageLocal {
    void finaliserVoyage(long idNavette, long idReservation, long idQuai) throws NavetteInconnuException, ReservationInconnuException,QuaiInconnuException;
    void reserverVoyage (long idStationD, long idStationA, long nbPassager, Date dateA, long idEmprunteur,Date dateOpe)throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException;
    void demarrerVoyage (long idReservation)throws ReservationInconnuException;
}
