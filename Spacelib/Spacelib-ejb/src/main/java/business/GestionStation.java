/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;


import entities.Navette;
import entities.Quai;
import entities.Station;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.NavetteFacadeLocal;
import repositories.QuaiFacadeLocal;
import repositories.StationFacadeLocal;

/**
 *
 * @author jb
 */
@Stateless
public class GestionStation implements GestionStationLocal {

    @EJB
    private StationFacadeLocal stationfacade;
    
    @EJB
    private QuaiFacadeLocal quaiFacade;
    
    @EJB
    private NavetteFacadeLocal navetteFacade;
    
    @Override
    public List<Station> consulterStation() {
        return stationfacade.getAllStations();
    }

    @Override
    public void ajouterStation(long idStation) throws StationInconnuException  {
        final Station s = stationfacade.find(idStation);
        if (s == null) {
            throw new StationInconnuException();
        }
        stationfacade.create(s);
    }

    @Override
    public void supprimerStation(long idStation) throws StationInconnuException{
        Station s = stationfacade.find(idStation);
        if (s == null) {
            throw new StationInconnuException();
        }
        stationfacade.remove(s);
    }

    @Override
    public void ModifierStation(long idStation)  throws StationInconnuException{
        Station s = stationfacade.find(idStation);
        if (s == null) {
            throw new StationInconnuException();
        }
        stationfacade.edit(s);
    }

    @Override
    public void ajouterQuai(long idStation, long idQuai) throws StationInconnuException, QuaiInconnuException{
        Station s = stationfacade.find(idStation);
        if (s == null) {
            throw new StationInconnuException();
        }
        Quai quai = quaiFacade.find(idQuai);
        if (quai == null) {
            throw new QuaiInconnuException();
        }
        s.getListeQuais().add(quai);
        stationfacade.edit(s);
    }

    @Override
    public void modifierQuai(long idQuai) throws QuaiInconnuException{
        Quai quai = quaiFacade.find(idQuai);
        if (quai == null) {
            throw new QuaiInconnuException();
        }
        quaiFacade.edit(quai);
    }

    @Override
    public void supprimerQuai(long idQuai) throws QuaiInconnuException{
        Quai quai = quaiFacade.find(idQuai);
        if (quai == null) {
            throw new QuaiInconnuException();
        }
        quaiFacade.edit(quai);
    }

    @Override
    public void acheterNavette(long idNavette, long idQuai) throws NavetteInconnuException, QuaiInconnuException{
        Quai quai = quaiFacade.find(idQuai);
        if (quai == null) {
            throw new QuaiInconnuException();
        }
        Navette navette = navetteFacade.find(idNavette);
        if (navette == null) {
            throw new NavetteInconnuException();
        }
        navetteFacade.create(navette);
        navetteFacade.arrimer(navette, quai);
    }

    @Override
    public void modifierNavette(long idNavette) throws NavetteInconnuException{
        Navette navette = navetteFacade.find(idNavette);
        if (navette == null) {
            throw new NavetteInconnuException();
        }
        navetteFacade.edit(navette);
    }

    @Override
    public void supprimerNavette(long idNavette) throws NavetteInconnuException{
        Navette navette = navetteFacade.find(idNavette);
        if (navette == null) {
            throw new NavetteInconnuException();
        }
        navetteFacade.remove(navette);
    }

}
