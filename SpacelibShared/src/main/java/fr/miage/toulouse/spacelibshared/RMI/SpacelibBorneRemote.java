/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.spacelibshared.RMI;

import fr.miage.toulouse.spacelibshared.admin.ObjReservation;
import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import fr.miage.toulouse.spacelibshared.admin.ObjUsager;
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
 *
 * @author pierreliaubet
 */
@Remote
public interface SpacelibBorneRemote {
    void finaliserVoyage(long idReservation) throws NavetteInconnuException, ReservationInconnuException,QuaiInconnuException;
    long reserverVoyage (long idStationD, long idStationA, int nbPassager, long idEmprunteur,Date dateOpe)throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException;
    void demarrerVoyage (long idReservation)throws ReservationInconnuException;
    List<ObjStation> consulterStation() ;
    ObjUsager authentifier(String login, String password) throws UsagerInconnuException;
    long creerUsager(String nom, String prenom, String login, String password);
    Long derniereReservation(long idUsager) throws UsagerInconnuException;
    
}
