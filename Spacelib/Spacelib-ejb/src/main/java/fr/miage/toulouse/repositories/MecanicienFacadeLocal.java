/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Mecanicien;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface MecanicienFacadeLocal {

    /**
     * créer un nouveau mécanicien 
     * @param mecanicien mécanicien à créer 
     */
    void create(Mecanicien mecanicien);

    /**
     * modifie un mécanicien 
     * @param mecanicien mécanicien à modifier 
     */
    void edit(Mecanicien mecanicien);

    /**
     * supprime un mécanicien 
     * @param mecanicien mécanicien à supprimer 
     */
    void remove(Mecanicien mecanicien);

    /**
     * retourne un mécanicien
     * @param id Id du mécanicien à renvoyer 
     * @return le mécanicien 
     */
    Mecanicien find(Object id);

    /**
     * Retourne tous les mécaniciens 
     * @return List<Mecanicien> les mécaniciens
     */
    List<Mecanicien> findAll();

    List<Mecanicien> findRange(int[] range);

    /**
     * retourne le nombre de mécaniciens 
     * @return le nombre de mécaniciens
     */
    int count();
    
}
