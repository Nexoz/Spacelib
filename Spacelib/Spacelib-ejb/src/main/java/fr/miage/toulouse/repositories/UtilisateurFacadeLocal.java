/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 * Interface de la façade des utilsiateurs
 * @author jb
 */
@Local
public interface UtilisateurFacadeLocal {

    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);

    int count();
    
    /**
     * Permet de s'authentifier
     * @param login identifiant de l'usager
     * @param MDP mot de passe du compte
     * @return l'utilisateur du compte
     */
    Utilisateur authentifier(String login, String MDP);
    
}
