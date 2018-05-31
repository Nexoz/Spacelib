/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.business.GestionStationLocal;
import fr.miage.toulouse.spacelibshared.RMI.SpacelibAdminRemote;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
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
    public List consulterStation() {
        return gestionStation.consulterStation();
    }

    @Override
    public void ajouterStation(long idStation) throws StationInconnuException {
        gestionStation.ajouterStation("","");
    }

    @Override
    public void supprimerStation(long idStation) throws StationInconnuException {
        gestionStation.supprimerStation(idStation);
    }

    @Override
    public void ModifierStation(long idStation) throws StationInconnuException {
        gestionStation.ModifierStation(idStation);
    }

    @Override
    public void ajouterQuai(long idStation, long idQuai) throws StationInconnuException, QuaiInconnuException {
        gestionStation.ajouterQuai(idStation, idQuai);
    }

    @Override
    public void modifierQuai(long idQuai) throws QuaiInconnuException {
        gestionStation.modifierQuai(idQuai);
    }

    @Override
    public void supprimerQuai(long idQuai) throws QuaiInconnuException {
        gestionStation.supprimerQuai(idQuai);
    }

    @Override
    public void acheterNavette(long idNavette, long idQuai) throws NavetteInconnuException, QuaiInconnuException {
        gestionStation.acheterNavette(idNavette, idQuai);
    }

    @Override
    public void modifierNavette(long idNavette) throws NavetteInconnuException {
        gestionStation.modifierNavette(idNavette);
    }

    @Override
    public void supprimerNavette(long idNavette) throws NavetteInconnuException {
        gestionStation.supprimerNavette(idNavette);
    }
    
    
    
}
