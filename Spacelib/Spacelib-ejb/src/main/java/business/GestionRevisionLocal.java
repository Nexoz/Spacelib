/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Navette;
import entities.Revision;
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
public interface GestionRevisionLocal {
    
    Revision selectionnerRevision(Long idStation, Long idNavette, Long idMecanicien) throws StationInconnuException, NavetteInconnuException;
    List<Navette> listerNavetteAReviser(Long idStation) throws StationInconnuException;
    void finaliserRevision(Long idRevision) throws RevisionInconnuException;
    List<Revision> getRevisionsEnCours(Long idStation) throws StationInconnuException;
}
