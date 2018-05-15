/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Navette;
import entities.Operation;
import entities.Station;
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
    
    
}
