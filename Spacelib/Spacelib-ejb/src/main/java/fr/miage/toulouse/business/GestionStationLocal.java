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
import fr.miage.toulouse.spacelibshared.exceptions.MecanicienInconnuException;
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
    void ajouterStation(String nom, String position, List<Quai> quais);
    void supprimerStation(long idStation) throws StationInconnuException;
    void ModifierStation(Station station) throws StationInconnuException;
    void ajouterQuai(long idStation, Quai quai) throws StationInconnuException, QuaiInconnuException;
    void modifierQuai(long idQuai) throws QuaiInconnuException;
    void supprimerQuai(long idQuai)throws QuaiInconnuException;
    void acheterNavette (Navette navette)throws NavetteInconnuException, QuaiInconnuException;
    void modifierNavette (Navette navette)throws NavetteInconnuException;
    void supprimerNavette (long idNavette)throws NavetteInconnuException;
    Station getStationById(long idStation);
    void ajoutouMecano(Mecanicien mecano);
    Navette getNavette (long id) throws NavetteInconnuException;

    public Mecanicien getLeMecano(long id);
    void modifierMecanicien(Mecanicien mecano);
    void supprimerMecanicien(long id) throws MecanicienInconnuException;
    
}
