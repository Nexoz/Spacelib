/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Station;
import java.util.List;
import javax.ejb.Local;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Navette;
/**
 *
 * @author jb
 */
@Local
public interface StationFacadeLocal {

    void create(Station station);

    void edit(Station station);

    void remove(Station station);

    Station find(Object id);

    List<Station> findAll();

    List<Station> findRange(int[] range);

    int count();
    
    List<Station> getAllStations();
    
    void ajouterQuai(Station station,Quai q);
    
    int getTempsTrajet(Station station);
    
    List<Quai> getQuais(Station station);
    
    List<Quai> getQuaisDispo(long station);
    
}
