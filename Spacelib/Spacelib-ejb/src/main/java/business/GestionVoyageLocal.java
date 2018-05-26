/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface GestionVoyageLocal {
    void finaliserVoyage(long idNavette, long idReservation, long idQuai) throws NavetteInconnuException, ReservationInconnuException,QuaiInconnuException;
    void reserverNavette (long idNavette, long idReservetion, long idQuaiDepart)throws NavetteInconnuException, ReservationInconnuException,QuaiInconnuException;
}
