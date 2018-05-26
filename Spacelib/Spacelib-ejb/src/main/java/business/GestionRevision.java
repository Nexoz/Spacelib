/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Navette;
import entities.Quai;
import entities.Revision;
import entities.Station;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.NavetteFacadeLocal;
import repositories.QuaiFacadeLocal;
import repositories.RevisionFacadeLocal;
import repositories.StationFacadeLocal;

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
    public List<Navette> listerNavetteAReviser(Long idStation) {
        Station s = stationFacade.find(idStation);
        if(s != null){
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
        return null;
    }

    @Override
    public void finaliserRevision(Long idRevision) {
        Revision r = revisionFacade.find(idRevision);
        if (r != null) {
            revisionFacade.finRevision(r);
            navetteFacade.resetRevision(revisionFacade.getNavette(r)); 
        }
    }

    @Override
    public Revision selectionnerRevision(Long idStation, Long idNavette) {
        Station s = stationFacade.find(idStation);
        Navette n = navetteFacade.find(idNavette);
        if (s != null && n != null) {
            Revision r = new Revision();
            r.setNavette(n); 
            Calendar now = Calendar.getInstance(Locale.FRENCH);
            r.setLibelle("Révision de la navette " + n.getId() + " sur " + s.getNom() + " le " + now.toString());
            Revision res = revisionFacade.debutRevision(r);
            return res;
        }
        return null;
    }

    @Override
    public List<Revision> getRevisionsEnCours(Long idStation) {
        Station s = stationFacade.find(idStation);
        if (s != null) {
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
        return null;
    }
}
