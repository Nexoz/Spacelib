/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse;

import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Revision;
import fr.miage.toulouse.entities.Station;
import fr.miage.toulouse.spacelibshared.exceptions.NavetteInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.RevisionInconnuException;
import fr.miage.toulouse.spacelibshared.exceptions.StationInconnuException;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import fr.miage.toulouse.services.ServiceMecanicienLocal;

/**
 *
 * @author jb
 */
@WebService(serviceName = "WebServiceMecanicien")
@Stateless()
public class WebServiceMecanicien {

    @EJB
    private ServiceMecanicienLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "authentifierMecanicien")
    public Mecanicien authentifierMecanicien(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        return ejbRef.authentifierMecanicien(login, password);
    }

    @WebMethod(operationName = "getListStations")
    public List<Station> getListStations() {
        return ejbRef.getListStations();
    }

    @WebMethod(operationName = "selectionnerRevision")
    public Revision selectionnerRevision(@WebParam(name = "ids") Long ids, @WebParam(name = "idn") Long idn) throws StationInconnuException, NavetteInconnuException {
        return ejbRef.selectionnerRevision(ids, idn);
    }

    @WebMethod(operationName = "listerNavetteAReviser")
    public List<Navette> listerNavetteAReviser(@WebParam(name = "ids") Long ids) throws StationInconnuException {
        return ejbRef.listerNavetteAReviser(ids);
    }

    @WebMethod(operationName = "finaliserRevision")
    public void finaliserRevision(@WebParam(name = "idr") Long idr) throws RevisionInconnuException {
        ejbRef.finaliserRevision(idr);
    }

    @WebMethod(operationName = "getRevisionsEnCours")
    public List<Revision> getRevisionsEnCours(@WebParam(name = "ids") Long ids) throws StationInconnuException {
        return ejbRef.getRevisionsEnCours(ids);
    }
    
}
