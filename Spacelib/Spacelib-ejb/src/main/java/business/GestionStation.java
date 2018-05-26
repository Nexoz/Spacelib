/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Station;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import repositories.StationFacadeLocal;

/**
 *
 * @author jb
 */
@Stateless
public class GestionStation implements GestionStationLocal {

    @EJB
    private StationFacadeLocal stationfacade;
    
    @Override
    public List<Station> consulterStation() {
        return stationfacade.getAllStations();
    }

    @Override
    public void ajouterStation(Station station) {
        stationfacade.create(station);
    }

}
