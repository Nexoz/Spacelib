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
import java.util.List;
import javax.ejb.Local;

/**
 * Interface de la façade des révisions
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
    
     /**
     * Marque le début de la révision
     * @param r Révision concernée
     * @return 
     */
    Revision debutRevision(Revision r);
 
    /**
     * Marque la fin de la révision
     * @param r Révision concernée
     */
    void finRevision(Revision r);
    
     /**
     * Dit si la révision est en cours
     * @param r Révision concernée
     * @return Vrai si la révision est en cours
     */   
    boolean estEnCours(Revision r);
    
     /**
     * Dit si la révision est terminée
     * @param r Révision concernée
     * @return Vrai si la révision est terminée
     */
    boolean estTerminee(Revision r);
    
    /**
     * Renvoie la navette d'une révision
     * @param r la résision
     * @return navette
     */
    Navette getNavette(Revision r);
    
    /**
     * Renvoie la révision en cours d'une navette
     * @param n navette à vérifier
     * @return révision en cours
     */
    Revision getCurrentRevisionByNavette(Navette n);
    
    /**
     * Permet de créer une révison
     * @param texte libellé de la révision
     * @param quaiD quai où la révision s'opère
     * @param navette navette à réviser
     * @param mecanicien mécanicien en charge de la révision
     * @return Revision
     */
    Revision creerRevision(String texte, Quai quaiD, Navette navette,Mecanicien mecanicien);
}
