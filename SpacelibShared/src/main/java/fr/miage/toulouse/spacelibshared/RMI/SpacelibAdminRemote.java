/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.spacelibshared.RMI;

import fr.miage.toulouse.spacelibshared.admin.ObjMecanicien;
import fr.miage.toulouse.spacelibshared.admin.ObjNavette;
import fr.miage.toulouse.spacelibshared.admin.ObjQuai;
import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import fr.miage.toulouse.spacelibshared.exceptions.MecanicienInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Pierre
 */
@Remote
public interface SpacelibAdminRemote {
    
    /**
     * Retourne la liste des stations de Spacelib avec les quais qui y sont rattachés
     * @return List<ObjStation> liste des stations de Spacelib
     */
    List<ObjStation> consulterStation();
    
    /**
     * Ajoute une station à Spacelib 
     * @param station ObjSation à ajouter 
     * @throws StationInconnuException 
     */
    void ajouterStation(ObjStation station) throws StationInconnuException;
    
    /**
     * Supprime une station de spacelib
     * @param station ObjStation à supprimer 
     * @throws StationInconnuException 
     */
    void supprimerStation(ObjStation station) throws StationInconnuException;
    
    /**
     * Modifie la station passée en paramètre 
     * @param station ObjStation à modifier
     * @throws StationInconnuException 
     */
    void modifierStation(ObjStation station) throws StationInconnuException;
    
    /**
     * retroue la liste des quais 
     * @return List<Quai> des quais de Spacelib
     */
    List<ObjQuai> getLesQuais();
    
    /**
     * Retourne la liste des quais disponibles dans une sation 
     * @param station Id de la station concernée 
     * @return List<ObjQuai> des quais disponibles dans la station 
     */
    List<ObjQuai> getLesQuaisDispo(long station);
    
    /**
     * Ajoute un quai à une station de spacelib
     * @param station ObjStation de là où on ajoute le quai 
     * @param quai ObjQuai à ajouter dans le système de gestion de Spacelib
     * @throws StationInconnuException
     * @throws QuaiInconnuException 
     */
    void ajouterQuai(ObjStation station, ObjQuai quai) throws StationInconnuException, QuaiInconnuException;
    
    /**
     * Modifie un quai 
     * @param quai
     * @throws QuaiInconnuException 
     */
    void modifierQuai(ObjQuai quai) throws QuaiInconnuException;
    
    /**
     * Supprime un quai 
     * @param quai ObjQuai à supprimer 
     * @throws QuaiInconnuException 
     */
    void supprimerQuai(ObjQuai quai)throws QuaiInconnuException;
    
    /**
     * Retourne la liste des Navettes de SpaceLib
     * @return List<ObjNavette> les ObjNavettes de Spacelib 
     */
    List<ObjNavette> getLesNavettes();
    
    /**
     * Crée une nouvelle Navette dans le système de gestion de Spacelib 
     * @param navette ObjNavette à ajouter 
     * @throws NavetteInconnuException
     * @throws QuaiInconnuException 
     */
    void acheterNavette (ObjNavette navette)throws NavetteInconnuException, QuaiInconnuException;
    
    /**
     * Modifie une Navette 
     * @param navette ObjNavette à modifier 
     * @throws NavetteInconnuException 
     */
    void modifierNavette (ObjNavette navette)throws NavetteInconnuException;
    
    /**
     * Supprime une Navette du système de gestion de Spacelib
     * @param navette ObjNavette à supprimer
     * @throws NavetteInconnuException 
     */
    void supprimerNavette (ObjNavette navette)throws NavetteInconnuException;
    
    /**
     * Retourne la liste des mécaniciens de Spacelib
     * @return List<ObjMecanicien> des mécaniciens de Spacelib 
     */
    List<ObjMecanicien> getlesMecanos();
    
    /**
     * Ajoute un mécano dans le système de gestion de Spacelib
     * @param mecano ObjMecanicien à ajouter 
     */
    void ajouterMecano(ObjMecanicien mecano);
    
    /**
     * Modifie un Mecano dans le système de gestion de Spacelib
     * @param mecano ObjMecanicien à modifier 
     * @throws MecanicienInconnuException 
     */
    void modifierMecano(ObjMecanicien mecano) throws MecanicienInconnuException;
    
    /**
     * Supprime un Mecano du système de gestion de Spacelib 
     * @param mecano ObjMecano à supprimer
     * @throws MecanicienInconnuException 
     */
    void supprimerMecano(ObjMecanicien mecano) throws MecanicienInconnuException;
}
