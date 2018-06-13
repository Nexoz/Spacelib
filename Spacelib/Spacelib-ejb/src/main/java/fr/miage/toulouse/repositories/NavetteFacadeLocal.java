/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Operation;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Station;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface NavetteFacadeLocal {

    /**
     * creation de Navette 
     * @param navette navette à créer 
     */
    void create(Navette navette);

    /**
     * mise à jour de navette 
     * @param navette navette à modifier 
     */
    void edit(Navette navette);

    /**
     * supprimer une navette 
     * @param navette navette à supprimer 
     */
    void remove(Navette navette);

    /**
     * retourne une navette 
     * @param id id de la navette qu'on recherche 
     * @return la navette recherchée 
     */
    Navette find(Object id);

    /**
     * retourne toute les navettes 
     * @return la liste des navettes de Spacelib 
     */
    List<Navette> findAll();

    List<Navette> findRange(int[] range);

    /**
     * retourne le nombre de navettes de Spacelib 
     * @return le nombre de navettes de Spacelib
     */
    int count();
    
    
    /**
     * retourne si une navette attend une révision 
     * @param navette Navette dont on veut connaitre l'état 
     * @return true si elle attend une révision, false sinon 
     */
    boolean isWaitingRevision (Navette navette);
    
    /**
     * ajoute une opération sur une navette 
     * @param navette navette sur laquelle on veut ajouter une opération 
     * @param operation opération à ajouter sur la navette 
     */
    void ajouterOperation(Navette navette, Operation operation);
    
    /**
     * remet l'état de la récision à zéro 
     * @param navette Navette où on veut remettre les révision à 0 
     */
    void resetRevision(Navette navette);
    
    /**
     * arrime une navette à un quai 
     * @param navette navette qu'on arrime 
     * @param quai Quai où on arrime la navette 
     */
    void arrimer (Navette navette,Quai quai);
    
    /**
     * Désarrime la navette 
     * @param nanette navette à désarrimer 
     */
    void desarrimer (Navette nanette);
    
    /**
     * Ajoute un voyage donc décrémente le compteur avant révision 
     * @param navette navette qui effectue le voyage 
     */
    void incrementerVoyage (Navette navette);
    
    /**
     * passe la navette en état de révision (-1) 
     * @param navette navette qu'on passe en révision 
     */
    void passerEnRevision(Navette navette);
    
    /**
     * retourne si une navette est en révision 
     * @param navette navette dont on veut connaitre l'état 
     * @return retoune true si elle est en révision, false sinon 
     */
    boolean isEnRevision(Navette navette);

    /**
     * donne la disponibilité d'une navette 
     * @param navette navettes dont on veut connaitre l'état
     * @return retourne true si elle est disponible false sinon 
     */
    boolean isDisponible(Navette navette);
}
