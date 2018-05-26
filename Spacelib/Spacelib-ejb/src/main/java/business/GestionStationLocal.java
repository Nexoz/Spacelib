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
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface GestionStationLocal {
    List<Station> consulterStation();
    void ajouterStation(long idStation);
    void supprimerStation(Station station);
    void ModifierStation(Station station);
    void ajouterQuai(Station station, Quai quai);
    void modifierQuai(Quai quai);
    void supprimerQuai(Quai quai);
    void acheterNavette (Navette navette, Quai quai);
    void modifierNavette (Navette navette);
    void supprimerNavette (Navette navette);
}
