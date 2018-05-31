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
    
    void ajouterReservation(Usager usager,Reservation r);
    
   // Usager nouvelUsager( String nom,String prenom, String login, String password);
}