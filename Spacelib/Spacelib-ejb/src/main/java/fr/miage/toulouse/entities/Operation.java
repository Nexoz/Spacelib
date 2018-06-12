/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jb
 */
@Entity
@XmlSeeAlso({Station.class, Reservation.class})
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = LAZY)
    private Navette navette;
    
    @Temporal(TIMESTAMP)
    private Date dateFin;
    
    @Temporal(TIMESTAMP)
    private Date dateDebut;
    
    @Temporal(TIMESTAMP)
    private Date dateOperation;
    
    private Quai quaiOperation;

    public Operation(){}
    
    public Operation(String libelleOp, Quai quai, Navette nav, Date dateope) {
       this.dateOperation = dateope;
       this.libelle = libelleOp;
       this.navette = nav;
       this.quaiOperation = quai;
    }
    
    public Long getId() {
        return id;
    }
    
    private String libelle;

    public void setId(Long id) {
        this.id = id;
    }

    @XmlTransient
    public Navette getNavette() {
        return navette;
    }

    public void setNavette(Navette navette) {
        this.navette = navette;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public Quai getQuaiOperation() {
        return quaiOperation;
    }

    public void setQuaiOperation(Quai quaiOperation) {
        this.quaiOperation = quaiOperation;
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
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Operation[ id=" + id + " ]";
    }
    
}
