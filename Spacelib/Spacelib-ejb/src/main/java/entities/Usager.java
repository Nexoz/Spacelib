/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
public class Usager extends Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @OneToMany(fetch = LAZY, mappedBy = "reservation")
    private List<Reservation> listeReservations;
  
    @Override
    public String toString() {
        return "entities.Client[ id=" + this.getId() + " ]";
    }

    public List<Reservation> getListeReservations() {
        return listeReservations;
    }

    public void setListeReservations(List<Reservation> listeReservations) {
        this.listeReservations = listeReservations;
    }
    
}
