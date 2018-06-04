/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.entities.Utilisateur;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface ServiceReservationUsagerLocal {

    public Utilisateur authentifier(String login, String password);
    
}
