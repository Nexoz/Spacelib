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

    void create(Navette navette);

    void edit(Navette navette);

    void remove(Navette navette);

    Navette find(Object id);

    List<Navette> findAll();

    List<Navette> findRange(int[] range);

    int count();
    
    boolean isWaitingRevision (Navette navette);
    
    void ajouterOperation(Navette navette, Operation operation);
    
    void resetRevision(Navette navette);
    
    void arrimer (Navette navette,Quai quai);
    
    void desarrimer (Navette nanette);
    
    void incrementerVoyage (Navette navette);
    
    void passerEnRevision(Navette navette);
    
    boolean isEnRevision(Navette navette);

}
