/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.business.GestionStationLocal;
import fr.miage.toulouse.business.GestionUtilisateurLocal;
import fr.miage.toulouse.business.GestionVoyageLocal;
import fr.miage.toulouse.entities.Station;
import fr.miage.toulouse.entities.Usager;
import fr.miage.toulouse.entities.Utilisateur;
import fr.miage.toulouse.spacelibshared.RMI.SpacelibBorneRemote;
import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import fr.miage.toulouse.spacelibshared.admin.ObjUsager;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.PasNavetteDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.PasQuaiDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.UsagerInconnuException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author pierreliaubet
 */
@Stateless
public class ServiceBorneRMI implements SpacelibBorneRemote{
   
    @EJB
    GestionVoyageLocal gestionVoyage;
    
    @EJB
    GestionStationLocal gestionStation;
    
    @EJB
    GestionUtilisateurLocal gestionUtilisateur;
    
    @Override
    public void finaliserVoyage(long idNavette, long idReservation, long idQuai) throws NavetteInconnuException, ReservationInconnuException,QuaiInconnuException{
        gestionVoyage.finaliserVoyage(idNavette, idReservation, idQuai);
    }
    
    @Override
    public void reserverVoyage (long idStationD, long idStationA, long nbPassager, Date dateA, long idEmprunteur,Date dateOpe)throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException{
        gestionVoyage.reserverVoyage(idStationD, idStationA, nbPassager, dateA, idEmprunteur, dateOpe);
    }
    
    @Override
    public void demarrerVoyage (long idReservation)throws ReservationInconnuException{
        gestionVoyage.demarrerVoyage(idReservation);
    }
    
    @Override
    public List<ObjStation> consulterStation() {
        List<Station> stations = gestionStation.consulterStation();
        List<ObjStation> res = new ArrayList<>();
        for(Station s : stations) {
            res.add(new ObjStation(s.getId(), s.getNom(), s.getPosition(), null));
        }
        return res;
    }

    @Override
    public ObjUsager authentifier(String login, String password) throws UsagerInconnuException {
        Utilisateur u = gestionUtilisateur.authentifier(login, password);
        if(u instanceof Usager){
            return new ObjUsager(null, u.getId(), u.getNom(), u.getPrenom(), u.getLogin(), u.getPassword());
        }
        throw new UsagerInconnuException();
    }
    
}
