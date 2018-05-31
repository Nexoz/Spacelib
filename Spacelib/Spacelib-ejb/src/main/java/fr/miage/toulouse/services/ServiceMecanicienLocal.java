/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Revision;
import fr.miage.toulouse.entities.Station;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.RevisionInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
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
    Revision selectionnerRevision(Long ids, Long idn, Long idm) throws StationInconnuException, NavetteInconnuException ;
    List<Navette> listerNavetteAReviser(Long ids) throws StationInconnuException;
    void finaliserRevision(Long idr) throws RevisionInconnuException;
    List<Revision> getRevisionsEnCours(Long ids)throws StationInconnuException;
}