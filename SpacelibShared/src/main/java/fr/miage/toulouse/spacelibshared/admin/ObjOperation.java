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
public class ObjOperation implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private long id;
    private ObjNavette navette;
    private Date dateDebut;
    private Date dateFin;
    private Date dateOperation;
    private ObjQuai quaiOperation;
    
    public ObjOperation(){
        
    }

    public ObjOperation(long id, ObjNavette navette, Date dateDebut, Date dateFin, Date dateOperation, ObjQuai quaiOperation) {
        this.id = id;
        this.navette = navette;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dateOperation = dateOperation;
        this.quaiOperation = quaiOperation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ObjNavette getNavette() {
        return navette;
    }

    public void setNavette(ObjNavette navette) {
        this.navette = navette;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public ObjQuai getQuaiOperation() {
        return quaiOperation;
    }

    public void setQuaiOperation(ObjQuai quaiOperation) {
        this.quaiOperation = quaiOperation;
    }
    
    
}
