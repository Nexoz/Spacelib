/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse;

import fr.miage.toulouse.entities.Utilisateur;
import fr.miage.toulouse.services.ServiceAdminComptesLocal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author jb
 */
@WebService(serviceName = "WebServiceAdminComptes")
@Stateless()
public class WebServiceAdminComptes {

    @EJB
    private ServiceAdminComptesLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "addMecano")
    public long addMecano(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom, @WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        return ejbRef.addMecano(nom, prenom, login, password);
    }
    
    @WebMethod()
    public Utilisateur authentifier(@WebParam(name = "login") String login, @WebParam(name = "password") String password){
        return ejbRef.authentifier(login, password);
    }
    
}
