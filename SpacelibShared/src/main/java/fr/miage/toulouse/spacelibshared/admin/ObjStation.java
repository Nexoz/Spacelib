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
public class ObjStation implements Serializable{
    private final static long serialVersionUID = 1L;
    
    private long id;
    private String nom;
    private String position;
    private List<ObjQuai> quais;
    
    public ObjStation(){
        
    }
    
    public ObjStation(long id, String nom, String position, List<ObjQuai> quais) {
        this.id = id;
        this.nom = nom;
        this.position = position;
        this.quais = quais;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<ObjQuai> getQuais() {
        return quais;
    }

    public void setQuais(List<ObjQuai> quais) {
        this.quais = quais;
    }

    @Override
    public String toString() {
        return id + " - " + nom + " (" + position + ")";
    }
    
    
    
    
}
