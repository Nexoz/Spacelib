/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Station;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface GestionStationLocal {
    List<Station> consulterStation();
    void ajouterStation(long idStation) throws StationInconnuException;
    void supprimerStation(long idStation) throws StationInconnuException;
    void ModifierStation(long idStation) throws StationInconnuException;
    void ajouterQuai(long idStation, long idQuai) throws StationInconnuException, QuaiInconnuException;
    void modifierQuai(long idQuai) throws QuaiInconnuException;
    void supprimerQuai(long idQuai)throws QuaiInconnuException;
    void acheterNavette (long idNavette, long idQuai)throws NavetteInconnuException, QuaiInconnuException;
    void modifierNavette (long idNavette)throws NavetteInconnuException;
    void supprimerNavette (long idNavette)throws NavetteInconnuException;
}
