/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Station;
import java.util.List;
import javax.ejb.Local;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Navette;
/**
 *
 * @author jb
 */
@Local
public interface StationFacadeLocal {

    /**
     * création d'une entité de station 
     * @param station Station à créer 
     */
    void create(Station station);

    /**
     * met à jour une station 
     * @param station Station à mettre à jour 
     */
    void edit(Station station);

    /**
     * Supprime une station 
     * @param station 
     */
    void remove(Station station);

    /**
     * Retourne un objet station 
     * @param id Id de la Station
     * @return entité de la station recherchée 
     */
    Station find(Object id);

    
    /**
     * retourne toutes les stations 
     * @return List<Station> Liste des stations 
     */
    List<Station> findAll();

    /**
     * 
     * @param range
     * @return 
     */
    List<Station> findRange(int[] range);

    /**
     * Retourne le nombre d'entités de stations 
     * @return le nombre d'entités de stations 
     */
    int count();
    
    /**
     * retourne toutes les stations 
     * @return List<Station> Liste des stations 
     */
    List<Station> getAllStations();
    
    /**
     * Ajoute un quai à une station 
     * @param station Station sur laquelle on ajoute un quai 
     * @param q Quai qu'on ajoute à la sation 
     */
    void ajouterQuai(Station station,Quai q);
    
    /**
     * Retourne le temps de de trajet
     * @param station
     * @return temps de trajet 
     */
    int getTempsTrajet(Station station);
    
    /**
     * Retourne les quais d'une station 
     * @param station Station qu'on interroge 
     * @return List<Quai> Liste des quais de la station 
     */
    List<Quai> getQuais(Station station);
    
    /**
     * Retourne les quais libres d'une station 
     * @param station id de la station 
     * @return List<Quai> Liste des quais libre de la station
     */
    List<Quai> getQuaisDispo(long station);
    
}
