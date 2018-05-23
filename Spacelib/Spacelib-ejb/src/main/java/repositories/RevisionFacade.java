/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Navette;
import entities.Revision;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jb
 */
@Stateless
public class RevisionFacade extends AbstractFacade<Revision> implements RevisionFacadeLocal {

    @PersistenceContext(unitName = "spacelibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RevisionFacade() {
        super(Revision.class);
    }
    
    /**
     * Marque le début de la révision
     * @param r Révision concernée
     * @return 
     */
    @Override
    public Revision debutRevision(Revision r) {
        r.setDateDebut(new Date());
        this.create(r);
        return r;
    }

    /**
     * Marque la fin de la révision
     * @param r Révision concernée
     */
    @Override
    public void finRevision(Revision r) {
        r.setDateFin(new Date());
    }

    /**
     * Dit si la révision est en cours
     * @param r Révision concernée
     * @return Vrai si la révision est en cours
     */
    @Override
    public boolean estEnCours(Revision r) {
        return r.getDateDebut() != null && r.getDateFin() == null;
    }

    /**
     * Dit si la révision est terminée
     * @param r Révision concernée
     * @return Vrai si la révision est terminée
     */
    @Override
    public boolean estTerminee(Revision r) {
        return r.getDateDebut() != null && r.getDateFin() != null;
    }

    @Override
    public Navette getNavette(Revision r) {
        return r.getNavette();
    }
    
}
