/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author jb
 */
@Entity
@XmlRootElement(name="usager")
@XmlSeeAlso({Reservation.class})
public class Usager extends Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(fetch = EAGER, mappedBy = "emprunteur")
    private List<Reservation> listeReservations;
  
    public Usager() {
    }
    
    public Usager(String nom, String prenom, String login, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.listeReservations = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return "entities.Client[ id=" + this.getId() + " ]";
    }

    @XmlElement(name="reservations")
    public List<Reservation> getListeReservations() {
        return listeReservations;
    }

    public void setListeReservations(List<Reservation> listeReservations) {
        this.listeReservations = listeReservations;
    }
    
}
