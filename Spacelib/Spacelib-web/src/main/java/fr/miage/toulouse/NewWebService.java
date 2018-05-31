/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import fr.miage.toulouse.services.ServiceTestLocal;

/**
 *
 * @author jb
 */
@WebService(serviceName = "NewWebService")
@Stateless()
public class NewWebService {

    @EJB
    private ServiceTestLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createStation")
    public void createStation(@WebParam(name = "name") String name) {
        ejbRef.createStation(name);
    }
    
}
