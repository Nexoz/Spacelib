/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.business.GestionStationLocal;
import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Operation;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Station;
import fr.miage.toulouse.spacelibshared.RMI.SpacelibAdminRemote;
import fr.miage.toulouse.spacelibshared.admin.ObjMecanicien;
import fr.miage.toulouse.spacelibshared.admin.ObjNavette;
import fr.miage.toulouse.spacelibshared.admin.ObjOperation;
import fr.miage.toulouse.spacelibshared.admin.ObjQuai;
import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import fr.miage.toulouse.spacelibshared.exceptions.MecanicienInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    
    private Station objStationToStation(ObjStation objStation){
        Station station = new Station();
        station.setId(objStation.getId());
        station.setNom(objStation.getNom());
        station.setPosition(objStation.getPosition());
        station.setListeQuais(new ArrayList<Quai>());
        for (ObjQuai quai : objStation.getQuais()){
            Quai tmp = new Quai();
            Navette nav = new Navette();
            tmp.setCodeQuai(quai.getCode());
            tmp.setId(quai.getId());
            if (quai.getNavette() != null){
                nav.setId(quai.getNavette().getId());
            }
            tmp.setStation(station);
            station.getListeQuais().add(tmp);
        }
        return station;
    }
    
    private Navette objNavetteToNavette(ObjNavette objNavette){
        Navette navette = new Navette();
        try {
           navette = gestionStation.getNavette(objNavette.getId());
        } catch (NavetteInconnuException ex) {
            Logger.getLogger(ServiceAdminRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        navette.setNbPlaces(objNavette.getNbPlaces());
        return navette;
    }
    
    private Mecanicien objMecanoToMecano(ObjMecanicien objMecano){
        Mecanicien mecano = new Mecanicien();
        mecano = gestionStation.getLeMecano(objMecano.getId());
        mecano.setLogin(objMecano.getLogin());
        mecano.setPassword(objMecano.getPassword());
        return mecano;
    }
    
    
    @Override
    public List<ObjStation> consulterStation() {
        List<Station> stations = gestionStation.consulterStation();
        List<ObjStation> objStations = new ArrayList<>();
        for(Station s : stations){
            ObjStation tmp = new ObjStation(s.getId(), s.getNom(), s.getPosition(), new ArrayList<ObjQuai>());
            for (Quai q : s.getListeQuais()){
                tmp.getQuais().add(new ObjQuai(q.getId(), q.getCodeQuai(),null, new ObjStation(0, q.getStation().getNom(), "", null)));
            }
            objStations.add(tmp);
        }
        return objStations;
    }

    @Override
    public void ajouterStation(ObjStation station) throws StationInconnuException {
        List<Quai> lesQuais = new ArrayList<>();
        for (ObjQuai quai : station.getQuais()){
            Quai tmp = new Quai();
            tmp.setCodeQuai(quai.getCode());
            if (quai.getNavette() != null){
                Navette navette = new Navette();
                navette.setId(quai.getNavette().getId());
            }
        }
        gestionStation.ajouterStation(station.getNom(), station.getPosition(), lesQuais);
    }

    @Override
    public void supprimerStation(ObjStation station) throws StationInconnuException {
        gestionStation.supprimerStation(station.getId());
    }

    @Override
    public void modifierStation(ObjStation station) throws StationInconnuException {
        Station update = objStationToStation(station);
        gestionStation.ModifierStation(update);
    }

    @Override
    public void ajouterQuai(ObjStation station, ObjQuai quai) throws StationInconnuException, QuaiInconnuException {
        Quai newQuai = new Quai();
        Station st = new Station();
        st.setId(station.getId());
        newQuai.setCodeQuai(quai.getCode());
        newQuai.setStation(st);
        if (quai.getNavette() != null){
            Navette navette = new Navette();
            navette.setId(quai.getNavette().getId());
            newQuai.setNavArrimée(navette);
        }
        gestionStation.ajouterQuai(station.getId(), newQuai);
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
    public void acheterNavette(ObjNavette navette) throws NavetteInconnuException, QuaiInconnuException {
        Navette eNavette = new Navette();
        eNavette.setNbPlaces(navette.getNbPlaces());
        if (navette.getQuai() != null){
            Quai quai = new Quai();
            quai.setId(navette.getQuai().getId());
            eNavette.setQuaiArrimage(quai);
        }
        gestionStation.acheterNavette(eNavette);
    }

    @Override
    public void modifierNavette(ObjNavette navette) throws NavetteInconnuException {
        Navette update = objNavetteToNavette(navette);
        gestionStation.modifierNavette(update);
    }

    @Override
    public void supprimerNavette(ObjNavette navette) throws NavetteInconnuException {
        gestionStation.supprimerNavette(navette.getId());
    }

    @Override
    public List<ObjQuai> getLesQuais() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObjNavette> getLesNavettes() {
        List<Navette> lesNavettes = gestionStation.getLesNavettes();
        List<ObjNavette> lesObjNavette = new ArrayList<>();
        for (Navette n : lesNavettes){
            ObjQuai q = new ObjQuai();
            if (n.getQuaiArrimage() != null){
                Quai tmp = n.getQuaiArrimage();
                q = new ObjQuai(tmp.getId(), tmp.getCodeQuai(), null, new ObjStation(0, tmp.getStation().getNom(), "", null));
            }
            List<ObjOperation> ope = new ArrayList<ObjOperation>();
            //for (Operation o : n.getListeOperations()){
            //    ope.add(new ObjOperation(o.getId(), null, o.getDateDebut(), o.getDateFin(), o.getDateOperation(), null));
            //}
            ObjNavette navette = new ObjNavette(n.getId(), n.getNbPlaces(), n.getProchaineRevision(), q, ope);
            lesObjNavette.add(navette);
        }
        return lesObjNavette;
    }

    @Override
    public List<ObjQuai> getLesQuaisDispo(long station) {
        
        List<Quai> lesQuais = gestionStation.getQuaiDispos(station);
        List<ObjQuai> quaisDispos = new ArrayList<>();
        for (Quai quai : lesQuais){
            quaisDispos.add(new ObjQuai(quai.getId(), quai.getCodeQuai(), null,null));
        }
        return quaisDispos;
    }

    @Override
    public List<ObjMecanicien> getlesMecanos() {
        List<Mecanicien> lesMecanos = gestionStation.getLesMecanos();
        List<ObjMecanicien> lesObjMecano = new ArrayList<>();
        for (Mecanicien mecano : lesMecanos){
            lesObjMecano.add(new ObjMecanicien(mecano.getId(), mecano.getNom(), mecano.getPrenom(), mecano.getLogin(), mecano.getPassword()));
        }
        return lesObjMecano;
    }  

    @Override
    public void ajouterMecano(ObjMecanicien mecano) {
        Mecanicien nouveau = new Mecanicien();
        nouveau.setLogin(mecano.getLogin());
        nouveau.setNom(mecano.getNom());
        nouveau.setPrenom(mecano.getPrenom());
        nouveau.setPassword(mecano.getPassword());
        gestionStation.ajoutouMecano(nouveau);
    }

    @Override
    public void modifierMecano(ObjMecanicien mecano) throws MecanicienInconnuException {
        Mecanicien update = objMecanoToMecano(mecano);
        gestionStation.modifierMecanicien(update);
    }

    @Override
    public void supprimerMecano(ObjMecanicien mecano) throws MecanicienInconnuException {
        gestionStation.supprimerMecanicien(mecano.getId());
    }
    
}
