/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.spacelibshared.RMI;

import java.util.List;

/**
 *
 * @author Pierre
 */
public interface SpacelibAdminRemote {
    void ajouterStation(long station);
    void supprimerStation(long station);
    void ModifierStation(long station);
    void ajouterQuai(long station, long quai);
    void modifierQuai(long quai);
    void supprimerQuai(long quai);
    void acheterNavette (long navette, long quai);
    void modifierNavette (long navette);
    void supprimerNavette (long navette);
    
    
}
