/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import business.GestionRevisionLocal;
import business.GestionStationLocal;
import business.GestionUtilisateurLocal;
import entities.Mecanicien;
import entities.Navette;
import entities.Revision;
import entities.Station;
import entities.Utilisateur;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jb
 */
@Stateless
public class ServiceMecanicien implements ServiceMecanicienLocal {

    @EJB
    private GestionUtilisateurLocal gestionUtilisateur;
    
    @EJB
    private GestionRevisionLocal gestionRevision;
    
    @EJB
    private GestionStationLocal gestionStation;
        
    
    @Override
    public Mecanicien authentifierMecanicien(String login, String password) {
        Utilisateur u = gestionUtilisateur.authentifier(login, password);
        if(u instanceof Mecanicien){
            return (Mecanicien) u;
        }else{
            return null;
        }          
    }

    @Override
    public List<Station> getListStations() {
        return gestionStation.consulterStation();
    }

    @Override
    public Revision selectionnerRevision(Long idStation, Long idNavette) {
        return gestionRevision.selectionnerRevision(idStation,idNavette);
    }

    @Override
    public List<Navette> listerNavetteAReviser(Long idStation) {
        return gestionRevision.listerNavetteAReviser(idStation);
    }

    @Override
    public void finaliserRevision(Long idRevision) {
        gestionRevision.finaliserRevision(idRevision);
    }

    @Override
    public List<Revision> getRevisionsEnCours(Long idStation) {
        return gestionRevision.getRevisionsEnCours(idStation);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
