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
    
    /**
     * Retourne la liste des stations de Spacelib avec les quais qui y sont rattachés
     * @return List<Stations> liste des stations de Spacelib
     */
    List<Station> consulterStation();
    
    /**
     * Retourne la liste des Navettes de SpaceLib
     * @return List<Navette> les ObjNavettes de Spacelib 
     */
    List<Navette> getLesNavettes();
    
    /**
     * Retourne la liste des mécaniciens de Spacelib
     * @return List<Mecanicien> des mécaniciens de Spacelib 
     */
    List<Mecanicien> getLesMecanos();
    
    /**
     * Retourne la liste des quais disponibles dans une sation 
     * @param station Id de la station concernée 
     * @return List<Quai> des quais disponibles dans la station 
     */
    List<Quai> getQuaiDispos(long station);
    
    /**
     * Ajoute une station à spacelib
     * @param nom nom de la station
     * @param position position de la station 
     * @param quais Liste des quais de la station 
     */
    void ajouterStation(String nom, String position, List<Quai> quais);
    
    /**
     * Supprime une station de Spacelib 
     * @param idStation id de la station à supprimer
     * @throws StationInconnuException 
     */
    void supprimerStation(long idStation) throws StationInconnuException;
    
    /**
     * Modifie la station passée en paramètre 
     * @param station Sation à modifier 
     * @throws StationInconnuException 
     */
    void ModifierStation(Station station) throws StationInconnuException;
    
    /**
     * Ajoute un quai à Spacelib
     * @param idStation Id de la Station à laquelle on ajoute le quai 
     * @param quai Quai qu'on ajoute à la sation 
     * @throws StationInconnuException
     * @throws QuaiInconnuException 
     */
    void ajouterQuai(long idStation, Quai quai) throws StationInconnuException, QuaiInconnuException;
    
    /**
     * Modifie un quai 
     * @param idQuai quai à modifier 
     * @throws QuaiInconnuException 
     */
    void modifierQuai(long idQuai) throws QuaiInconnuException;
    
    /**
     * Supprime un quai de Spacelib
     * @param idQuai Id qu quai à supprimer 
     * @throws QuaiInconnuException 
     */
    void supprimerQuai(long idQuai)throws QuaiInconnuException;
    
    /**
     * Ajoute une nouvelle navette dans le SG de spacelib
     * @param navette Navette à ajouter 
     * @throws NavetteInconnuException
     * @throws QuaiInconnuException 
     */
    void acheterNavette (Navette navette)throws NavetteInconnuException, QuaiInconnuException;
    
    /**
     * Modifie la navette passée en paramètres 
     * @param navette Navette à modifier 
     * @throws NavetteInconnuException 
     */
    void modifierNavette (Navette navette)throws NavetteInconnuException;
    
    /**
     * Supprime la navette 
     * @param idNavette id de la navette à supprimer 
     * @throws NavetteInconnuException 
     */
    void supprimerNavette (long idNavette)throws NavetteInconnuException;
    
    /**
     * Retourne une station à partir de son id 
     * @param idStation Id de la station 
     * @return entité de la station 
     */
    Station getStationById(long idStation);
    
    /**
     * Ajoute un Mecanicien dans le système de gestion de Spacelib 
     * @param mecano Mecanicien 
     */
    void ajoutouMecano(Mecanicien mecano);
    
    /**
     * Retourne une Navette à partir de son ID 
     * @param id Id de la navette 
     * @return La Navette 
     * @throws NavetteInconnuException 
     */
    Navette getNavette (long id) throws NavetteInconnuException;

    /**
     * retourne un mécanicien à partir de son ID
     * @param id Id du mécanicien 
     * @return Le mécanicien 
     */
    public Mecanicien getLeMecano(long id);
    
    /**
     * Modifie un mécanicien dans le système de gestion 
     * @param mecano Mecanicien à modifier 
     */
    void modifierMecanicien(Mecanicien mecano);
    
    /**
     * Supprime un mécanicien dans le système de gestion 
     * @param id id du mécanicien à supprimer 
     * @throws MecanicienInconnuException 
     */
    void supprimerMecanicien(long id) throws MecanicienInconnuException;
    
}
