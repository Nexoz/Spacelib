/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Navette;
import entities.Quai;
import entities.Station;
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
    public void ajouterStation(long idStation) {
        final Station station = this.stationfacade.find(idStation);
        stationfacade.create(station);
    }

    @Override
    public void supprimerStation(Station station) {
        stationfacade.remove(station);
    }

    @Override
    public void ModifierStation(Station station) {
        stationfacade.edit(station);
    }

    @Override
    public void ajouterQuai(Station station, Quai quai) {
        station.getListeQuais().add(quai);
        stationfacade.edit(station);
    }

    @Override
    public void modifierQuai(Quai quai) {
        quaiFacade.edit(quai);
    }

    @Override
    public void supprimerQuai(Quai quai) {
        quaiFacade.edit(quai);
    }

    @Override
    public void acheterNavette(Navette navette, Quai quai) {
        navetteFacade.create(navette);
        navetteFacade.arrimer(navette, quai);
    }

    @Override
    public void modifierNavette(Navette navette) {
        navetteFacade.edit(navette);
    }

    @Override
    public void supprimerNavette(Navette navette) {
        navetteFacade.remove(navette);
    }

}
