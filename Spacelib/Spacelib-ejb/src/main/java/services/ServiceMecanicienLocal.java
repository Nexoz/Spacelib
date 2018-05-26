/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Mecanicien;
import entities.Navette;
import entities.Revision;
import entities.Station;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface ServiceMecanicienLocal {
    
    Mecanicien authentifierMecanicien(String login, String password);
    List<Station> getListStations();
    Revision selectionnerRevision(Long ids, Long idn);
    List<Navette> listerNavetteAReviser(Long ids);
    void finaliserRevision(Long idr);
    List<Revision> getRevisionsEnCours(Long ids);
}
