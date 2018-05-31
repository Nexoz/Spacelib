/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.business;

import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Revision;
import fr.miage.toulouse.entities.Station;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.RevisionInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import fr.miage.toulouse.repositories.NavetteFacadeLocal;
import fr.miage.toulouse.repositories.QuaiFacadeLocal;
import fr.miage.toulouse.repositories.RevisionFacadeLocal;
import fr.miage.toulouse.repositories.StationFacadeLocal;

/**
 *
 * @author jb
 */
@Stateless
public class GestionRevision implements GestionRevisionLocal {

    @EJB
    private RevisionFacadeLocal revisionFacade;
    
    @EJB
    private StationFacadeLocal stationFacade;
    
    @EJB
    private QuaiFacadeLocal quaiFacade;
    
    @EJB
    private NavetteFacadeLocal navetteFacade;


    @Override
    public List<Navette> listerNavetteAReviser(Long idStation) throws StationInconnuException{
        Station s = stationFacade.find(idStation);
        if (s == null) {
            throw new StationInconnuException();
        }
        List<Quai> quais = stationFacade.getQuais(s);
        List<Navette> res = new ArrayList<>();
        for(Quai q : quais){
            Navette n = quaiFacade.getNavette(q);
            if(n != null && navetteFacade.isWaitingRevision(n)){
                res.add(n);
            }
        }

        return res;
    }

    @Override
    public void finaliserRevision(Long idRevision) throws RevisionInconnuException {
        Revision r = revisionFacade.find(idRevision);
        if (r == null) {
            throw new RevisionInconnuException();
        }
        revisionFacade.finRevision(r);
        navetteFacade.resetRevision(revisionFacade.getNavette(r)); 
    }

    @Override
    public Revision selectionnerRevision(Long idStation, Long idNavette) throws StationInconnuException, NavetteInconnuException {
        Station s = stationFacade.find(idStation);
        if (s == null) {
            throw new StationInconnuException();
        }
        Navette n = navetteFacade.find(idNavette);
        if (n == null) {
            throw new NavetteInconnuException();
        }
        Revision r = new Revision();
        r.setNavette(n); 
        Calendar now = Calendar.getInstance(Locale.FRENCH);
        r.setLibelle("Révision de la navette " + n.getId() + " sur " + s.getNom() + " le " + now.toString());
        Revision res = revisionFacade.debutRevision(r);
        return res;
    }

    @Override
    public List<Revision> getRevisionsEnCours(Long idStation) throws StationInconnuException{
        Station s = stationFacade.find(idStation);
        if (s == null) {
            throw new StationInconnuException();
        }
        List<Quai> quais = stationFacade.getQuais(s);
        List<Revision> res = new ArrayList<>();
        for (Quai q : quais) {
            Navette n = quaiFacade.getNavette(q);
            if (n != null && navetteFacade.isEnRevision(n)) {
                // La navette est en cours de révision
                res.add(revisionFacade.getCurrentRevisionByNavette(n));
            }
        }
        return res; 
    }
}
