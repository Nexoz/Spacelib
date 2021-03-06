/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jb
 */
@Stateless
public class QuaiFacade extends AbstractFacade<Quai> implements QuaiFacadeLocal {

    @PersistenceContext(unitName = "connectionPoolSpacelib")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuaiFacade() {
        super(Quai.class);
    }

    /**
     * Incrit en base de données l'arrimage de la navette sur un quai
     * @param quai Quai sur lequel la navette est arrimée
     * @param navette Navette qu'on arrime au Quai 
     */
    @Override
    public void arrimer(Quai quai,Navette navette) {
        quai.setNavArrimée(navette);
        quai.setDateReservation(null);
    }
    

    /**
     * Retourne si une navette est arrimée à un quai
     * @param quai Quai dont on veut connaitre l'état
     * @return true si une navette est arrimée - false sinon 
     */
    @Override
    public boolean hasNavette(Quai quai) {
        if (quai.getNavArrimée() == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Navette getNavette(Quai quai) {
        return quai.getNavArrimée();
    }
    
    @Override
    public void desarrimer(Quai quai) {
        quai.setNavArrimée(null);
    }

    @Override
    public boolean isDisponible(Quai quai) {
        return (!this.hasNavette(quai)) && quai.getDateReservation()==null;
    }

    @Override
    public void reserverQuai(Quai quaiA, Date dateA) {
       quaiA.setDateReservation(dateA);
    }
    
    
}
