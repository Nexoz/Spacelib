/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Operation;
import fr.miage.toulouse.entities.Quai;
import java.util.List;
import javax.ejb.Local;

/**
 * Interfce de la façade de l'opération
 * @author jb
 */
@Local
public interface OperationFacadeLocal {

    void create(Operation operation);

    void edit(Operation operation);

    void remove(Operation operation);

    Operation find(Object id);

    List<Operation> findAll();

    List<Operation> findRange(int[] range);

    int count();
    
    /**
     * Permet de créer une opération
     * @param libelle libellé de l'opération
     * @param quai quai où s'opère l'opération
     * @param nav navette de l'opération
     * @return operation
     */
    Operation creerOperation(String libelle,Quai quai, Navette nav);
    
}
