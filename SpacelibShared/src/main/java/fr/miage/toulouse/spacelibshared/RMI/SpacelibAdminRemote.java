/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.spacelibshared.RMI;

import fr.miage.toulouse.spacelibshared.admin.ObjMecanicien;
import fr.miage.toulouse.spacelibshared.admin.ObjNavette;
import fr.miage.toulouse.spacelibshared.admin.ObjQuai;
import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.QuaiInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Pierre
 */
@Remote
public interface SpacelibAdminRemote {
    List<ObjStation> consulterStation();
    void ajouterStation(ObjStation station) throws StationInconnuException;
    void supprimerStation(ObjStation station) throws StationInconnuException;
    void modifierStation(ObjStation station) throws StationInconnuException;
    List<ObjQuai> getLesQuais();
    List<ObjQuai> getLesQuaisDispo(long station);
    void ajouterQuai(ObjStation station, ObjQuai quai) throws StationInconnuException, QuaiInconnuException;
    void modifierQuai(ObjQuai quai) throws QuaiInconnuException;
    void supprimerQuai(ObjQuai quai)throws QuaiInconnuException;
    List<ObjNavette> getLesNavettes();
    void acheterNavette (ObjNavette navette)throws NavetteInconnuException, QuaiInconnuException;
    void modifierNavette (ObjNavette navette)throws NavetteInconnuException;
    void supprimerNavette (ObjNavette navette)throws NavetteInconnuException;
    List<ObjMecanicien> getlesMecanos();
    
}
