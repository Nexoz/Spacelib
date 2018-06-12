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

    void create(Usager usager);

    void edit(Usager usager);

    void remove(Usager usager);

    Usager find(Object id);

    List<Usager> findAll();

    List<Usager> findRange(int[] range);

    int count();
    
    /**
     * Permet d'ajouter une réservation à la liste des réservation de l'usager
     * @param usager l'usager
     * @param r réservation à enregistrer
     */
    void ajouterReservation(Usager usager,Reservation r);
    
    /**
     * Renvoie la liste de toutes les réservations d'un usager
     * @param usager l'usager
     * @return List de réservation
     */
    List<Reservation> reservationsUsager(Usager usager);
    
}
