/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.business;

import fr.miage.toulouse.entities.Utilisateur;
import fr.miage.toulouse.spacelibshared.exceptions.LoginUsedException;
import javax.ejb.Local;

/**
 * Interface de gestion des utilisateurs
 * @author jb
 */
@Local
public interface GestionUtilisateurLocal {
 
     /**
     * Tester si un compte a bien le bon couple login/password.
     * @param login login du compte
     * @param password mot de passe du compte
     * @return Objet utilisateur connecté
     */
    Utilisateur authentifier(String login, String password);
    
    /**
     * Créer un mécanicien.
     * @param nom nom du mécanicien
     * @param prenom prénom du mécanicien
     * @param login identifiant du mécanicien
     * @param password mot de passe du mécanicien
     * @return id du mécanicien
     * @throws fr.miage.toulouse.spacelibshared.exceptions.LoginUsedException
     */
    long creerMecanicien(String nom, String prenom, String login, String password) throws LoginUsedException;
    
    /**
     * Créer un usager.
     * @param nom nom de l'usager
     * @param prenom prénom de l'usager
     * @param login identifiant de l'usager
     * @param password mot de passe de l'usager
     * @return id de l'usager
     * @throws fr.miage.toulouse.spacelibshared.exceptions.LoginUsedException
     */
    long creerUsager(String nom, String prenom, String login, String password) throws LoginUsedException;
    
    /**
     * Permet de vérifier si un login est déjà utilisé.
     * @param login lofin à vérifier
     * @return true si le login est déjà utilisé
     */
    boolean isLoginUsed(String login);
}
