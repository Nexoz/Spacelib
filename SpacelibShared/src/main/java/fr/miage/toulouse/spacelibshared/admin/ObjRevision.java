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
public class ObjRevision extends ObjOperation implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private ObjMecanicien mecano;
    
    public ObjRevision(){
        
    }

    public ObjRevision(ObjMecanicien mecano, long id, ObjNavette navette, Date dateDebut, Date dateFin, Date dateOperation, ObjQuai quaiOperation) {
        super(id, navette, dateDebut, dateFin, dateOperation, quaiOperation);
        this.mecano = mecano;
    }

    public ObjMecanicien getMecano() {
        return mecano;
    }

    public void setMecano(ObjMecanicien mecano) {
        this.mecano = mecano;
    }
    
    
}
