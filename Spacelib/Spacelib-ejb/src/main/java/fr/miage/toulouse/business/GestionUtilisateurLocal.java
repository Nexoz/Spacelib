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
 *
 * @author jb
 */
@Local
public interface GestionUtilisateurLocal {
 
    Utilisateur authentifier(String login, String password);
    long creerMecanicien(String nom, String prenom, String login, String password) throws LoginUsedException;
    long creerUsager(String nom, String prenom, String login, String password) throws LoginUsedException;
    boolean isLoginUsed(String login);
}
