/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.business;

import fr.miage.toulouse.entities.Utilisateur;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface GestionUtilisateurLocal {
 
    Utilisateur authentifier(String login, String password);
    long creerCompte(long idUtilisateur);
    long creerMecanicien(String nom, String prenom, String login, String password);
}
