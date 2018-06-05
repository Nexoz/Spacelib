/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.business.GestionStationLocal;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Station;
import fr.miage.toulouse.spacelibshared.RMI.SpacelibAdminRemote;
import fr.miage.toulouse.spacelibshared.admin.ObjNavette;
import fr.miage.toulouse.spacelibshared.admin.ObjQuai;
import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author pierreliaubet
 */
@Stateless
public class ServiceAdminRMI implements SpacelibAdminRemote{

    @EJB
    GestionStationLocal gestionStation;

    @Override
    public List<ObjStation> consulterStation() {
        List<Station> stations = gestionStation.consulterStation();
        List<ObjStation> objStations = new ArrayList<>();
        for(Station s : stations){
            ObjStation tmp = new ObjStation(s.getId(), s.getNom(), s.getPosition(), new ArrayList<ObjQuai>());
            for (Quai q : s.getListeQuais()){
                tmp.getQuais().add(new ObjQuai(q.getId(), q.getCodeQuai(),null));
            }
            objStations.add(tmp);
        }
        return objStations;
    }

    @Override
    public void ajouterStation(ObjStation station) throws StationInconnuException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerStation(ObjStation station) throws StationInconnuException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierStation(ObjStation station) throws StationInconnuException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterQuai(ObjStation station, ObjQuai quai) throws StationInconnuException, QuaiInconnuException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierQuai(ObjQuai quai) throws QuaiInconnuException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerQuai(ObjQuai quai) throws QuaiInconnuException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void acheterNavette(ObjNavette navette, ObjQuai quai) throws NavetteInconnuException, QuaiInconnuException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierNavette(ObjNavette navette) throws NavetteInconnuException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerNavette(ObjNavette navette) throws NavetteInconnuException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
