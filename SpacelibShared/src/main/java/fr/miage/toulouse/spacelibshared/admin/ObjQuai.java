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
public class ObjQuai implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long id;
    private String code;
    private ObjNavette navette;
    private ObjStation station;
    
    public ObjQuai(){
        
    }

    public ObjQuai(long id, String code, ObjNavette navette) {
        this.id = id;
        this.code = code;
        this.navette = navette;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ObjNavette getNavette() {
        return navette;
    }

    public void setNavette(ObjNavette navette) {
        this.navette = navette;
    }

    @Override
    public String toString() {
        return "SL" + id + " - " + code ;
    }

    public ObjStation getStation() {
        return station;
    }

    public void setStation(ObjStation station) {
        this.station = station;
    }
    
    
}
