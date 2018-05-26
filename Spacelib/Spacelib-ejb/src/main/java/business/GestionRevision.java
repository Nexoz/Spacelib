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
    public List<Navette> listerNavetteAReviser(Station s) {
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
    public void finaliserRevision(Revision r) {
        revisionFacade.finRevision(r);
        navetteFacade.resetRevision(revisionFacade.getNavette(r));
    }

    @Override
    public Revision selectionnerRevision(Station s, Navette n) {
        Revision r = new Revision();
        r.setNavette(n); 
        Calendar now = Calendar.getInstance(Locale.FRENCH);
        r.setLibelle("Révision de la navette " + n.getId() + " sur " + s.getNom() + " le " + now.toString());
        Revision res = revisionFacade.debutRevision(r);
        return res;
    }

    @Override
    public List<Revision> getRevisionsEnCours(Station s) {
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
