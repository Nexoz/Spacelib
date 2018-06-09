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
public class ObjNavette implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long id;
    private int nbPlaces;
    private int prochaineRevision = 3;
    private ObjQuai quai;
    private List<ObjOperation> operations;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public int getProchaineRevision() {
        return prochaineRevision;
    }

    public void setProchaineRevision(int prochaineRevision) {
        this.prochaineRevision = prochaineRevision;
    }

    public ObjQuai getQuai() {
        return quai;
    }

    public void setQuai(ObjQuai quai) {
        this.quai = quai;
    }

    public List<ObjOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<ObjOperation> operations) {
        this.operations = operations;
    }

    public ObjNavette(){
        
    }
    
    public ObjNavette(long id, int nbPlaces, int prochaineRevision, ObjQuai quai, List<ObjOperation> operations) {
        this.id = id;
        this.nbPlaces = nbPlaces;
        this.prochaineRevision = prochaineRevision;
        this.quai = quai;
        this.operations = operations;
    }

    @Override
    public String toString() {
        return id + " : " + nbPlaces + " pl";
    }
    
    
    
}
