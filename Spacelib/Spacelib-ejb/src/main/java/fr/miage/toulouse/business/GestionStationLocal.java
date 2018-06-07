/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.business;

import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Station;
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
    List<Navette> getLesNavettes();
    List<Mecanicien> getLesMecanos();
    List<Quai> getQuaiDispos(long station);
    void ajouterStation(String nom, String position);
    void supprimerStation(long idStation) throws StationInconnuException;
    void ModifierStation(long idStation) throws StationInconnuException;
    void ajouterQuai(long idStation, Quai quai) throws StationInconnuException, QuaiInconnuException;
    void modifierQuai(long idQuai) throws QuaiInconnuException;
    void supprimerQuai(long idQuai)throws QuaiInconnuException;
    void acheterNavette (Navette navette, long idQuai)throws NavetteInconnuException, QuaiInconnuException;
    void modifierNavette (long idNavette)throws NavetteInconnuException;
    void supprimerNavette (long idNavette)throws NavetteInconnuException;
    Station getStationById(long idStation);
}
