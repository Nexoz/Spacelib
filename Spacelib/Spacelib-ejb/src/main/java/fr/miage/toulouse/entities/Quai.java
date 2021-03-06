/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jb
 */
@Entity
@XmlSeeAlso({Station.class, Reservation.class})
public class Quai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String codeQuai;
    
    @OneToOne(fetch = FetchType.EAGER)
    private Navette navArrimée;
    
    @ManyToOne(fetch = LAZY)
    private Station station;
    
    public Quai() {}

    private Date DateReservation = null;

    public Date getDateReservation() {
        return DateReservation;
    }

    public void setDateReservation(Date DateReservation) {
        this.DateReservation = DateReservation;
    }
    
    public Navette getNavArrimée() {
        return navArrimée;
    }

    public void setNavArrimée(Navette navArrimée) {
        this.navArrimée = navArrimée;
    }

    @XmlTransient
    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeQuai() {
        return codeQuai;
    }

    public void setCodeQuai(String codeQuai) {
        this.codeQuai = codeQuai;
    }
    
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quai)) {
            return false;
        }
        Quai other = (Quai) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Quai[ id=" + id + " ]";
    }
    
}
