/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.spacelibshared.admin;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author pierreliaubet
 */
public class ObjUsager extends ObjUtilisateur implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private List<ObjReservation> listeReservation;

    public ObjUsager(List<ObjReservation> listeReservation) {
        this.listeReservation = listeReservation;
    }

    public ObjUsager(List<ObjReservation> listeReservation, long id, String nom, String prenom, String login, String password) {
        super(id, nom, prenom, login, password);
        this.listeReservation = listeReservation;
    }

    public List<ObjReservation> getListeReservation() {
        return listeReservation;
    }

    public void setListeReservation(List<ObjReservation> listeReservation) {
        this.listeReservation = listeReservation;
    }
    
    
    
    
}
