/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.business;

import fr.miage.toulouse.entities.Mecanicien;
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
import fr.miage.toulouse.repositories.MecanicienFacadeLocal;
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
    
    @EJB
    private MecanicienFacadeLocal mecanicienFacade;

    /**
     * Liste les différentes navettes d'un station ayant besoin d'une révision
     * @param idStation Identifiant de la station souhaitée
     * @return Liste de Navette à réviser (peut être vide)
     * @throws StationInconnuException Si la station est inconnue
     */
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

    /**
     * Terminer une révision et rendre la navette à nouveau disponible
     * @param idRevision
     * @throws RevisionInconnuException 
     */
    @Override
    public void finaliserRevision(Long idRevision) throws RevisionInconnuException {
        Revision r = revisionFacade.find(idRevision);
        if (r == null) {
            throw new RevisionInconnuException();
        }
        revisionFacade.finRevision(r);
        navetteFacade.resetRevision(revisionFacade.getNavette(r)); 
    }

    /**
     * Démarre la révision d'une navette
     * @param idStation Station concernée
     * @param idNavette Navette concernée
     * @param idMecanicien Mécanicien qui réalise la révision
     * @return
     * @throws StationInconnuException
     * @throws NavetteInconnuException 
     */
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
        navetteFacade.passerEnRevision(navette);
        Revision res = revisionFacade.creerRevision("Révision de la navette " + navette.getId() + " sur " + station.getNom(), navette.getQuaiArrimage(), navette, mecanicien);
        navetteFacade.ajouterOperation(navette, res);
        return res;
    }

    /**
     * Permet d'avoir les révisions en cours dans une station
     * @param idStation Station concernée
     * @return Liste de révision (peut être vide)
     * @throws StationInconnuException Si la station est inconnue
     */
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
