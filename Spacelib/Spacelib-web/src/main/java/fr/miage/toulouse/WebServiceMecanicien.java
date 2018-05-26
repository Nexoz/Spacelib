/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse;

import entities.Mecanicien;
import entities.Navette;
import entities.Revision;
import entities.Station;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import services.ServiceMecanicienLocal;

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
    public Revision selectionnerRevision(@WebParam(name = "ids") Long ids, @WebParam(name = "idn") Long idn) {
        return ejbRef.selectionnerRevision(ids, idn);
    }

    @WebMethod(operationName = "listerNavetteAReviser")
    public List<Navette> listerNavetteAReviser(@WebParam(name = "ids") Long ids) {
        return ejbRef.listerNavetteAReviser(ids);
    }

    @WebMethod(operationName = "finaliserRevision")
    @Oneway
    public void finaliserRevision(@WebParam(name = "idr") Long idr) {
        ejbRef.finaliserRevision(idr);
    }

    @WebMethod(operationName = "getRevisionsEnCours")
    public List<Revision> getRevisionsEnCours(@WebParam(name = "ids") Long ids) {
        return ejbRef.getRevisionsEnCours(ids);
    }
    
}
