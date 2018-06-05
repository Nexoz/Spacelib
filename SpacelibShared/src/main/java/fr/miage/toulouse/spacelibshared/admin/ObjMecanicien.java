/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.spacelibshared.admin;

import java.io.Serializable;

/**
 *
 * @author pierreliaubet
 */
public class ObjMecanicien extends ObjUtilisateur implements Serializable{

    public ObjMecanicien() {
    }

    public ObjMecanicien(long id, String nom, String prenom, String login, String password) {
        super(id, nom, prenom, login, password);
    }
    
}
