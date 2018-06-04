/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.business.GestionUtilisateurLocal;
import fr.miage.toulouse.entities.Utilisateur;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jb
 */
@Stateless
public class ServiceReservationUsager implements ServiceReservationUsagerLocal {

    @EJB
    private GestionUtilisateurLocal gestUtilisateur; 
    
    @Override
    public Utilisateur authentifier(String login, String password) {
        return gestUtilisateur.authentifier(login, password);
    }
}
