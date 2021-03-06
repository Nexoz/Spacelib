/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;


import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Operation;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Revision;
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

    @PersistenceContext(unitName = "connectionPoolSpacelib")
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
        if (navette.getProchaineRevision() >= 3){
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
        navette.setProchaineRevision(3);
    }

    @Override
    public void arrimer(Navette navette ,Quai quai) {
        navette.setQuaiArrimage(quai);
    }

    @Override
    public void desarrimer(Navette navette) {
        navette.getQuaiArrimage().setDateReservation(null);
        navette.setQuaiArrimage(null);
    }

    @Override
    public void incrementerVoyage(Navette navette) {
        navette.setProchaineRevision(navette.getProchaineRevision()+1);
    }

    @Override
    public void passerEnRevision(Navette navette) {
        navette.setProchaineRevision(-1);
    }

    @Override
    public boolean isEnRevision(Navette navette) {
        if (navette.getProchaineRevision() == -1){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Une navette est  disponible si elle est à quai dans une station et qu'elle n'est pas en révision
     * @param navette
     * @return 
     */
    @Override
    public boolean isDisponible(Navette navette){
        System.out.println("fr.miage.toulouse.repositories.NavetteFacade.isDisponible()  est en révision " + isEnRevision(navette));
        System.out.println("fr.miage.toulouse.repositories.NavetteFacade.isDisponible()  est en attente de révision " + isWaitingRevision(navette));
        System.out.println("fr.miage.toulouse.repositories.NavetteFacade.isDisponible()  a un quai d'arrirame " + navette.getQuaiArrimage());
        return !isEnRevision(navette) && !isWaitingRevision(navette) && navette.getQuaiArrimage()!=null;
    }

    
}
