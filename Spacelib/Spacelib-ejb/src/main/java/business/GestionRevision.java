/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Mecanicien;
import entities.Navette;
import entities.Quai;
import entities.Revision;
import entities.Station;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.RevisionInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.MecanicienFacadeLocal;
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
    
    @EJB
    private MecanicienFacadeLocal mecanicienFacade;


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
    public Revision selectionnerRevision(Long idStation, Long idNavette, Long idMecanicien) throws StationInconnuException, NavetteInconnuException {
        Station station = stationFacade.find(idStation);
        if (station == null) {
            throw new StationInconnuException();
        }
        Navette navette = navetteFacade.find(idNavette);
        if (navette == null) {
            throw new NavetteInconnuException();
        }
        Mecanicien mecanicien = mecanicienFacade.find(idMecanicien);
        if (mecanicien == null) {
            throw new NavetteInconnuException();
        }
        Revision res = revisionFacade.creerRevision("Révision de la navette " + navette.getId() + " sur " + station.getNom(), navette.getQuaiArrimage(), navette, mecanicien);
        navetteFacade.ajouterOperation(navette, res);
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
