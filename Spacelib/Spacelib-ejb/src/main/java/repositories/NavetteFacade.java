/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Navette;
import entities.Operation;
import entities.Quai;
import entities.Station;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jb
 */
@Stateless
public class NavetteFacade extends AbstractFacade<Navette> implements NavetteFacadeLocal {

    @PersistenceContext(unitName = "spacelibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NavetteFacade() {
        super(Navette.class);
    }

    /**
     * Retoune l'état de révision de la navette
     * @param navette Navette dont on veut connaitre l'état de révision
     * @return true si la navette est a réviser - false sinon 
     */
    @Override
    public boolean isWaitingRevision (Navette navette) {
        if (navette.getProchaineRevision() < 3){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Ajoute une opération à la liste de la navette 
     * @param navette Navette où on ajoute l'opération
     * @param operation Opération à ajouter à la navette
     */
    @Override
    public void ajouterOperation(Navette navette, Operation operation) {
        navette.getListeOperations().add(operation);
    }

    /**
     * Remet le compteur de révision à 0
     * @param navette Navette dont on veut remettre le compteur à 0
     */
    @Override
    public void resetRevision(Navette navette) {
        navette.setProchaineRevision(0);
    }

    @Override
    public void arrimer(Navette navette ,Quai quai) {
        navette.setQuaiArrimage(quai);
    }

    @Override
    public void desarrimer(Navette navette) {
        navette.setQuaiArrimage(null);
    }

    @Override
    public void incrementerVoyage(Navette navette) {
        navette.setProchaineRevision(navette.getProchaineRevision()-1);
    }
    
}
