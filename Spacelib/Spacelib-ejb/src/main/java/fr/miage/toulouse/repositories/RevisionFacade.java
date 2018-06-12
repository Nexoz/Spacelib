/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Revision;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Façade de la Révision
 * @author jb
 */
@Stateless
public class RevisionFacade extends AbstractFacade<Revision> implements RevisionFacadeLocal {

    @PersistenceContext(unitName = "connectionPoolSpacelib")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RevisionFacade() {
        super(Revision.class);
    }
    

    @Override
    public Revision debutRevision(Revision r) {
        r.setDateDebut(new Date());
        this.create(r);
        return r;
    }


    @Override
    public void finRevision(Revision r) {
        r.setDateFin(new Date());
    }


    @Override
    public boolean estEnCours(Revision r) {
        return r.getDateDebut() != null && r.getDateFin() == null;
    }


    @Override
    public boolean estTerminee(Revision r) {
        return r.getDateDebut() != null && r.getDateFin() != null;
    }

    @Override
    public Navette getNavette(Revision r) {
        return r.getNavette();
    }

    @Override
    public Revision getCurrentRevisionByNavette(Navette n) {
        List<Revision> revi = this.findAll();
        for (Revision r : revi) {
            if (Objects.equals(r.getNavette().getId(), n.getId()) && r.getDateFin() != null) {
                return r;
            }
        }
        return null;
    }
    
    @Override
    public Revision creerRevision(String texte, Quai quaiD, Navette navette, Mecanicien mecanicien) {
        Calendar now = Calendar.getInstance(Locale.FRENCH);
        Revision c = new Revision( texte,  quaiD, navette, now.getTime(), mecanicien);
        this.create(c);
        return c;
    }
}
