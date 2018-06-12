/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Operation;
import fr.miage.toulouse.entities.Quai;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jb
 */
@Stateless
public class OperationFacade extends AbstractFacade<Operation> implements OperationFacadeLocal {

    @PersistenceContext(unitName = "connectionPoolSpacelib")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperationFacade() {
        super(Operation.class);
    }
    
    public Operation creerOperation(String libelle,Quai quai,Navette nav){
        Calendar now = Calendar.getInstance(Locale.FRENCH);
        Date d = now.getTime();
        Operation operation = new Operation("Révision nécessaire",quai,nav, d);
        operation.setDateDebut(d);
        operation.setDateFin(d);
        this.create(operation);
        return operation;
    }
}
