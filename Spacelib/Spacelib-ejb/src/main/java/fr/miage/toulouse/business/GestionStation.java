/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.business;


import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Station;
import fr.miage.toulouse.repositories.MecanicienFacadeLocal;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import fr.miage.toulouse.repositories.NavetteFacadeLocal;
import fr.miage.toulouse.repositories.QuaiFacadeLocal;
import fr.miage.toulouse.repositories.StationFacadeLocal;

/**
 *
 * @author jb
 */
@Stateless
public class GestionStation implements GestionStationLocal {

    @EJB
    private StationFacadeLocal stationfacade;
    
    @EJB
    private QuaiFacadeLocal quaiFacade;
    
    @EJB
    private NavetteFacadeLocal navetteFacade;
    
    @EJB
    private MecanicienFacadeLocal mecanoFacade;
    
    @Override
    public List<Station> consulterStation() {
        return stationfacade.getAllStations();
    }

    @Override
    public void ajouterStation(String nom, String position) {
        Station s = new Station(nom, position);
        stationfacade.create(s);
        System.out.println(s.getId());
    }

    @Override
    public void supprimerStation(long idStation) throws StationInconnuException{
        Station s = stationfacade.find(idStation);
        if (s == null) {
            throw new StationInconnuException();
        }
        stationfacade.remove(s);
    }

    @Override
    public void ModifierStation(long idStation)  throws StationInconnuException{
        Station s = stationfacade.find(idStation);
        if (s == null) {
            throw new StationInconnuException();
        }
        stationfacade.edit(s);
    }

    @Override
    public void ajouterQuai(long idStation, Quai quai) throws StationInconnuException, QuaiInconnuException{
        Station s = stationfacade.find(idStation);
        if (s == null) {
            throw new StationInconnuException();
        }
        s.getListeQuais().add(quai);
        stationfacade.edit(s);
    }

    @Override
    public void modifierQuai(long idQuai) throws QuaiInconnuException{
        Quai quai = quaiFacade.find(idQuai);
        if (quai == null) {
            throw new QuaiInconnuException();
        }
        quaiFacade.edit(quai);
    }

    @Override
    public void supprimerQuai(long idQuai) throws QuaiInconnuException{
        Quai quai = quaiFacade.find(idQuai);
        if (quai == null) {
            throw new QuaiInconnuException();
        }
        quaiFacade.edit(quai);
    }

    @Override
    public void acheterNavette(Navette navette, long quaiA) throws NavetteInconnuException, QuaiInconnuException{
        Quai quai = quaiFacade.find(quaiA);
        if (quai == null) {
            throw new QuaiInconnuException();
        }
        
        navetteFacade.create(navette);
        navetteFacade.arrimer(navette, quai);
        quaiFacade.arrimer(quai, navette);
    }

    @Override
    public void modifierNavette(long idNavette) throws NavetteInconnuException{
        Navette navette = navetteFacade.find(idNavette);
        if (navette == null) {
            throw new NavetteInconnuException();
        }
        navetteFacade.edit(navette);
    }

    @Override
    public void supprimerNavette(long idNavette) throws NavetteInconnuException{
        Navette navette = navetteFacade.find(idNavette);
        if (navette == null) {
            throw new NavetteInconnuException();
        }
        navetteFacade.remove(navette);
    }
    
    @Override
    public Station getStationById(long idStation) {
        return stationfacade.find(idStation);
    }

    @Override
    public List<Navette> getLesNavettes() {
        return navetteFacade.findAll();
    }

    @Override
    public List<Mecanicien> getLesMecanos() {
        return mecanoFacade.findAll();
    }

    @Override
    public List<Quai> getQuaiDispos(long station) {
        return stationfacade.getQuaisDispo(station);
    }

}
