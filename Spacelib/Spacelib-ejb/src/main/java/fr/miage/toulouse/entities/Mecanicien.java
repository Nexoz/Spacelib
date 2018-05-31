/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jb
 */
@Entity
public class Mecanicien extends Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    public Mecanicien() {
    }
    
    @Override
    public String toString() {
        return "entities.Mechanician[ id=" + this.getId() + " ]";
    }
    
}
