/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse;

import fr.miage.toulouse.entities.Mecanicien;
import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
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
import java.util.ArrayList;
import java.util.HashMap;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author jb
 */
@WebService(serviceName = "WebServiceMecanicien")
@SOAPBinding(style = Style.RPC) 
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
    public ListWrapper<Station> getListStations() {
        List<Station> a = ejbRef.getListStations();
        ListWrapper<Station> w = new ListWrapper<>(a);
        return w;
    }

    @WebMethod(operationName = "selectionnerRevision")
    public Revision selectionnerRevision(@WebParam(name = "ids") Long ids, @WebParam(name = "idn") Long idn, @WebParam(name = "idm") Long idm) throws StationInconnuException, NavetteInconnuException {
        return ejbRef.selectionnerRevision(ids, idn, idm);
    }

    
    @WebMethod(operationName = "listerNavetteAReviser")
    public ListWrapper<Navette> listerNavetteAReviser(@WebParam(name = "ids") Long ids) throws StationInconnuException {
        List<Navette> a = ejbRef.listerNavetteAReviser(ids);
        ListWrapper<Navette> w = new ListWrapper<>(a);
        return w;
    }

    @WebMethod(operationName = "finaliserRevision")
    public void finaliserRevision(@WebParam(name = "idr") Long idr) throws RevisionInconnuException {
        ejbRef.finaliserRevision(idr);
    }

    @WebMethod(operationName = "getRevisionsEnCours")
    public ListWrapper<Revision> getRevisionsEnCours(@WebParam(name = "ids") Long ids) throws StationInconnuException {
        List<Revision> a = ejbRef.getRevisionsEnCours(ids);
        ListWrapper<Revision> w = new ListWrapper<>(a);
        return w;
    }
    
    @WebMethod(operationName = "getQuaisFromStation")
    public ListWrapper<Quai> getQuaisFromStation(@WebParam(name = "ids") Long ids) throws StationInconnuException {
        List<Quai> q = ejbRef.getQuaisFromStation(ids);
        ListWrapper<Quai> w = new ListWrapper<>(q);
        return w;
    }
    
}
