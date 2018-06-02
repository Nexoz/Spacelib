/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse;

import fr.miage.toulouse.entities.Station;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import fr.miage.toulouse.services.ServiceTestLocal;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author jb
 */
@WebService(serviceName = "WebServiceTest")
@SOAPBinding(style = SOAPBinding.Style.RPC) 
@Stateless()
public class WebServiceTest {

    @EJB
    private ServiceTestLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createStation")
    public boolean createStation(@WebParam(name = "name") String name) {
        ejbRef.createStation(name);
        return true;
    }
    
    @WebMethod(operationName = "getStationById")
    public Station getStationById(@WebParam(name = "ids") Long ids) {
        return ejbRef.getStationById(ids);
    }
    
}
