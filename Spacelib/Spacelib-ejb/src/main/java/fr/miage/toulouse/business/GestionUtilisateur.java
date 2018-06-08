/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.business;

import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Usager;
import fr.miage.toulouse.entities.Utilisateur;
import fr.miage.toulouse.repositories.MecanicienFacadeLocal;
import fr.miage.toulouse.repositories.UsagerFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import fr.miage.toulouse.repositories.UtilisateurFacadeLocal;
import fr.miage.toulouse.spacelibshared.exceptions.LoginUsedException;
import java.util.List;

/**
 * Gestion des comptes utilisateurs
 * @author jb
 */
@Stateless
public class GestionUtilisateur implements GestionUtilisateurLocal {

    @EJB
    private UtilisateurFacadeLocal utfl;
    
    @EJB
    private UsagerFacadeLocal usfl;
    
    @EJB
    private MecanicienFacadeLocal mfl;
    
    /**
     * Tester si un compte a bien le bon couple login/password
     * @param login 
     * @param password
     * @return Objet utilisateur connecté
     */
    @Override
    public Utilisateur authentifier(String login, String password) {
        return utfl.authentifier(login, password);
    }

    /**
     * Créer un usager
     * @param nom
     * @param prenom
     * @param login
     * @param password
     * @return id de l'usager
     * @throws fr.miage.toulouse.spacelibshared.exceptions.LoginUsedException
     */
    @Override
    public long creerUsager(String nom, String prenom, String login, String password) throws LoginUsedException {
        if(!isLoginUsed(login)){
            Usager m = new Usager(nom, prenom, login, password);
            usfl.create(m);
            return m.getId();
        } else {
            throw new LoginUsedException("Login déjà utilisé");
        }
        
    }
    
    /**
     * Créer un mécanicien
     * @param nom
     * @param prenom
     * @param login
     * @param password
     * @return id du mécanicien
     * @throws fr.miage.toulouse.spacelibshared.exceptions.LoginUsedException
     */
    @Override
    public long creerMecanicien(String nom, String prenom, String login, String password) throws LoginUsedException {
        if(!isLoginUsed(login)){
            Mecanicien m = new Mecanicien(nom, prenom, login, password);
            mfl.create(m);
            return m.getId();
        } else {
            throw new LoginUsedException("Login déjà utilisé");
        }      
    }
    
    @Override
    public boolean isLoginUsed(String login) {
        List<Utilisateur> users = utfl.findAll();
        for (Utilisateur u : users) {
            if(u.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
