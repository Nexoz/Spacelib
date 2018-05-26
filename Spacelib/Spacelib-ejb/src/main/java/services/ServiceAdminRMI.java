/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import business.GestionStationLocal;
import entities.Navette;
import entities.Quai;
import entities.Station;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Pierre
 */
public class ServiceAdminRMI extends UnicastRemoteObject implements ServiceAdminRMI {

    @EJB
    private GestionStationLocal gestionStation;
    
    @Override
    public List<Station> consulterStation() {
        List<Station> list = gestionStation.consulterStation();
        return list;
    }

    @Override
    public void ajouterStation(Station station) {
        gestionStation.ajouterStation(station);
    }

    @Override
    public void supprimerStation(Station station) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ModifierStation(Station station) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterQuai(Station station, Quai quai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierQuai(Quai quai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerQuai(Quai quai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void acheterNavette(Navette navette, Quai quai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierNavette(Navette navette) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerNavette(Navette navette) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
