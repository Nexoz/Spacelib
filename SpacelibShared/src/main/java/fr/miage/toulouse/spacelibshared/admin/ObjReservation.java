/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.spacelibshared.admin;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author pierreliaubet
 */
public class ObjReservation extends ObjOperation implements Serializable{
    private static final long serialVerisonUID = 1L;
    
    private ObjQuai quaiArrivee;
    private ObjUsager emprunteur;
    
    public ObjReservation(){
        
    }

    public ObjReservation(ObjQuai quaiArrivee, ObjUsager emprunteur, long id, ObjNavette navette, Date dateDebut, Date dateFin, Date dateOperation, ObjQuai quaiOperation) {
        super(id, navette, dateDebut, dateFin, dateOperation, quaiOperation);
        this.quaiArrivee = quaiArrivee;
        this.emprunteur = emprunteur;
    }

    public ObjQuai getQuaiArrivee() {
        return quaiArrivee;
    }

    public void setQuaiArrivee(ObjQuai quaiArrivee) {
        this.quaiArrivee = quaiArrivee;
    }

    public ObjUsager getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(ObjUsager emprunteur) {
        this.emprunteur = emprunteur;
    }
    
    
}
