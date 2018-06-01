/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.business.GestionUtilisateurLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jb
 */
@Stateless
public class ServiceAdminComptes implements ServiceAdminComptesLocal {

    @EJB
    private GestionUtilisateurLocal gestUtilisateur; 

    @Override
    public long addMecano(String nom, String prenom, String login, String password) {
        return gestUtilisateur.creerMecanicien(nom, prenom, login, password);
    }
    
    
}
