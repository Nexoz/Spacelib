/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse;

import fr.miage.toulouse.entities.Station;
import fr.miage.toulouse.entities.Utilisateur;
import fr.miage.toulouse.services.ServiceReservationUsagerLocal;
import fr.miage.toulouse.spacelibshared.exceptions.LoginUsedException;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author jb
 */
@WebService(serviceName = "WebServiceReservationUsager")
@Stateless()
public class WebServiceReservationUsager {

    @EJB
    private ServiceReservationUsagerLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "authentifier")
    public Utilisateur authentifier(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        return ejbRef.authentifier(login, password);
    }
    
    @WebMethod(operationName = "calculerDistance")
    public Integer calculerDistance(@WebParam(name = "nomStationD") String nomStationD, @WebParam(name = "nomStationA") String nomStationA) {
        return ejbRef.calculerDistance(nomStationD, nomStationA);
    }
    
    @WebMethod(operationName = "creerUsager")
    public long creerUsager(@WebParam(name = "surname") String nom, @WebParam(name = "name") String prenom, @WebParam(name = "login") String login, @WebParam(name = "password") String password) throws LoginUsedException {
        return ejbRef.creerUsager(nom, prenom, login, password);
    }
    
}
