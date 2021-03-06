/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.business.GestionUtilisateurLocal;
import fr.miage.toulouse.business.GestionVoyageLocal;
import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Reservation;
import fr.miage.toulouse.entities.Usager;
import fr.miage.toulouse.entities.Utilisateur;
import fr.miage.toulouse.spacelibshared.exceptions.LoginUsedException;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.PasNavetteDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.PasQuaiDisponibleException;
import fr.miage.toulouse.spacelibshared.exceptions.ReservationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.UsagerInconnuException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jb
 */
@Stateless
public class ServiceReservationUsager implements ServiceReservationUsagerLocal {

    @EJB
    private GestionUtilisateurLocal gestUtilisateur; 
    
    @EJB
    private GestionVoyageLocal gestVoyage;
    
    @Override
    public Usager authentifier(String login, String password) {
        Utilisateur u = gestUtilisateur.authentifier(login, password);
        if(u instanceof Usager){
            return (Usager) u;
        }else{
            return null;
        } 
    }

    @Override
    public Integer calculerDistance(String nomStationD, String nomStationA) {
        return gestVoyage.calculerDistance(nomStationD, nomStationA);
    }
    
    @Override
    public long creerUsager(String nom, String prenom, String login, String password) throws LoginUsedException {
        return gestUtilisateur.creerUsager(nom, prenom, login, password);
    }
    
    @Override
    public long reserverVoyage (long idStationD, long idStationA, int nbPassager, long idEmprunteur, Date dateOpe, Date dateDebut) throws NavetteInconnuException,StationInconnuException,PasNavetteDisponibleException,PasQuaiDisponibleException,UsagerInconnuException{
        return gestVoyage.reserverVoyage(idStationD, idStationA, nbPassager, idEmprunteur, dateOpe, dateDebut);
    }
    
    @Override
    public List<Reservation> getReservationsForUsager(long idUsager) throws UsagerInconnuException {
        return gestVoyage.getReservationsForUsager(idUsager);
    }
    
    @Override
    public void annulerReservation(long idReservation) throws ReservationInconnuException {
        gestVoyage.annulerReservation(idReservation);
    }
    
    
}
