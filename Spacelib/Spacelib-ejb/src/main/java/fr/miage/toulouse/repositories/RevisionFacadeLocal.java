/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Revision;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface RevisionFacadeLocal {

    void create(Revision revision);
    
    void edit(Revision revision);

    void remove(Revision revision);

    Revision find(Object id);

    List<Revision> findAll();

    List<Revision> findRange(int[] range);

    int count();
    
    Revision debutRevision(Revision r);
    
    void finRevision(Revision r);
    
    boolean estEnCours(Revision r);
    
    boolean estTerminee(Revision r);
    
    Navette getNavette(Revision r);
    
    Revision getCurrentRevisionByNavette(Navette n);
    
    Revision creerRevision(String texte, Quai quaiD, Navette navette,Mecanicien mecanicien);
}
