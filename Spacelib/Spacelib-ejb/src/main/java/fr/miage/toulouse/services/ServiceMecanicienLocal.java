/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Revision;
import fr.miage.toulouse.entities.Station;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.RevisionInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface ServiceMecanicienLocal {
    
    /**
     * Authentifie un mécanicien
     * @param login
     * @param password
     * @return L'objet si bien loggé
     */
    Mecanicien authentifierMecanicien(String login, String password);
    
    /**
     * Permet d'avoir toutes les stations existantes
     * @return 
     */
    List<Station> getListStations();
    
    /**
     * Choix d'une navette par un mécanicien pour mise en révision
     * @param ids Id de la station où est située la navette
     * @param idn Id de la navette
     * @param idm Id du mécanicien
     * @return L'objet Révision correspondant à cette opération
     * @throws StationInconnuException
     * @throws NavetteInconnuException 
     */
    Revision selectionnerRevision(Long ids, Long idn, Long idm) throws StationInconnuException, NavetteInconnuException ;
    
    /**
     * Liste les navettes à réviser pour une station donnée
     * @param ids Id de la station
     * @return
     * @throws StationInconnuException 
     */
    List<Navette> listerNavetteAReviser(Long ids) throws StationInconnuException;
    
    /**
     * Finalise un révision pour remettre la navette disponible
     * @param idr Id de la révision
     * @throws RevisionInconnuException 
     */
    void finaliserRevision(Long idr) throws RevisionInconnuException;
    
    /**
     * Retourne les différentes révisions en cours dans la station
     * @param ids Id de la station
     * @return
     * @throws StationInconnuException 
     */
    List<Revision> getRevisionsEnCours(Long ids)throws StationInconnuException;
    
    /** 
     * Permet d'avoir la liste des quais d'une station
     * @param idStation Id de la station
     * @return
     * @throws StationInconnuException 
     */
    List<Quai> getQuaisFromStation(Long idStation) throws StationInconnuException;
}
