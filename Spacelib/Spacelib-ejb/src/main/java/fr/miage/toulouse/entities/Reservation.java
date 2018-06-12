/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.ManyToOne;

/**
 *
 * @author jb
 */
@Entity
public class Reservation extends Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    

    private Quai quaiArrivee;
    
    @ManyToOne(fetch = LAZY)
    private Usager emprunteur;
    
    private int nbPassager;

    public Reservation() {
    }
    
    public Reservation(String texte, Quai quaiDepart, Quai quaiA, Usager emprunteur, int nbPassager, Navette navDisponible, Date dateOpe, Date dateDebut) {//String voyage_initié, Quai quaiD, Quai quaiA, Date dateA, long idEmprunteur, long nbPassager, Navette navDisponible
        super.setQuaiOperation(quaiDepart);
        this.quaiArrivee = quaiA;
        this.emprunteur=emprunteur;
        this.setDateOperation(dateOpe);
        this.setNavette(navDisponible);
        this.setLibelle(texte);
        this.setDateDebut(dateDebut);
        this.setDateFin(null);
        this.nbPassager = nbPassager;
    }
    
    @Override
    public String toString() {
        return "Réservation " + super.toString();
    }

    public Quai getQuaiArrivee() {
        return quaiArrivee;
    }

    public void setQuaiArrivee(Quai quaiArrivee) {
        this.quaiArrivee = quaiArrivee;
    }

    public int getNbPassager() {
        return nbPassager;
    }

    public void setNbPassager(int nbPassager) {
        this.nbPassager = nbPassager;
    }

    public Usager getEmprunteur() {
        return emprunteur;
    }
    
    
    
}
