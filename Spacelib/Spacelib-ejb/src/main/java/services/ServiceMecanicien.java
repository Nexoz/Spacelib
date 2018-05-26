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
    public Revision selectionnerRevision(Station s, Navette n) {
        return gestionRevision.selectionnerRevision(s, n);
    }

    @Override
    public List<Navette> listerNavetteAReviser(Station s) {
        return gestionRevision.listerNavetteAReviser(s);
    }

    @Override
    public void finaliserRevision(Revision r) {
        gestionRevision.finaliserRevision(r);
    }

    @Override
    public List<Revision> getRevisionsEnCours(Station s) {
        return gestionRevision.getRevisionsEnCours(s);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
