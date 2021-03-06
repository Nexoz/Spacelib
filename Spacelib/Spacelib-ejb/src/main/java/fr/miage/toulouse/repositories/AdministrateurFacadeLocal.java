/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Administrateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface AdministrateurFacadeLocal {

    void create(Administrateur administrateur);

    void edit(Administrateur administrateur);

    void remove(Administrateur administrateur);

    Administrateur find(Object id);

    List<Administrateur> findAll();

    List<Administrateur> findRange(int[] range);

    int count();
    
}
