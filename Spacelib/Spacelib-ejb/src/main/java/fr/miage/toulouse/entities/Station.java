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
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jb
 */
@Entity
public class Station implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String position;
    private String nom;
    
    @OneToMany(fetch = LAZY, mappedBy = "station")
    private List<Quai> listeQuais;
    
    public Station() {}
    
    public Station(String nom, String position) {
        this.nom = nom;
        this.position = position;
        this.listeQuais = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Quai> getListeQuais() {
        return listeQuais;
    }

    public void setListeQuais(List<Quai> listeQuais) {
        this.listeQuais = listeQuais;
    }

    @Override
    public String toString() {
        return "entities.Station[ id=" + id + " ]";
    }
    
}