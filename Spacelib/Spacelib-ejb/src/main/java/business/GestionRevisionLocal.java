/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

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
public interface GestionRevisionLocal {
    
    Revision selectionnerRevision(Station s, Navette n);
    List<Navette> listerNavetteAReviser(Station s);
    void finaliserRevision(Revision r);
    List<Revision> getRevisionsEnCours(Station s);
}
