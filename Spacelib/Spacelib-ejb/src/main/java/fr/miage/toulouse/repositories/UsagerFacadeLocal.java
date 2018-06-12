/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Reservation;
import fr.miage.toulouse.entities.Usager;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface UsagerFacadeLocal {

    /**
     * Creation d'un usager 
     * @param usager usager à créer 
     */
    void create(Usager usager);

    /**
     * Modification d'un usager 
     * @param usager usager à modifier 
     */
    void edit(Usager usager);

    /**
     * Supprime un usager 
     * @param usager usager à supprimer 
     */
    void remove(Usager usager);

    
    /**
     * Retourne un usager 
     * @param id id de l'usager à renvoyer 
     * @return usager à trouver 
     */
    Usager find(Object id);

    /**
     * Retourne tous les usagers 
     * @return List<Usager> les usagers de Spacelib
     */
    List<Usager> findAll();

    /**
     *
     * @param range
     * @return 
     */
    List<Usager> findRange(int[] range);

    /**
     * Retourne le nombre d'usagers de Spacelib
     * @return 
     */
    int count();
    
    /**
     * Ajoute une réservation à un usager
     * @param usager l'usager à qui on ajoute une opération 
     * @param r Réxservation à ajouter à l'usager 
     */
    void ajouterReservation(Usager usager,Reservation r);
    
    /**
     * retourne la liste des réservations d'un usager 
     * @param usager l'usager dont on veut les réservations
     * @return List<Reservation> liste des réservations de l'usager 
     */
    List<Reservation> reservationsUsager(Usager usager);
    
   // Usager nouvelUsager( String nom,String prenom, String login, String password);
}
