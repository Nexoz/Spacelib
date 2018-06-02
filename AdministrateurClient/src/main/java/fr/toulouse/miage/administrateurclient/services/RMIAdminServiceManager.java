/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.toulouse.miage.administrateurclient.services;

import fr.miage.toulouse.spacelibshared.RMI.SpacelibAdminRemote;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author pierreliaubet
 */
public class RMIAdminServiceManager {
    private final static String GLASSFISH_ORB_HOST = "localhost";
    private final static String GLASSFISH_ORB_PORT = "3700";
    private final static String SERVICES_ADMIN_EJB_URI = "java:global/Spacelib-ejb/ServiceAdminRMI!fr.miage.toulouse.spacelibshared.RMI.SpacelibAdminRemote";

    private InitialContext namingContext;
    private SpacelibAdminRemote splacelibAdmin;

    public RMIAdminServiceManager() throws NamingException {
        this.initJndi();
        this.retrieveRemoteServicesAdmin();
    }

    private void initJndi() throws NamingException {
        Properties jNDIProperties = new Properties();
        jNDIProperties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        jNDIProperties.setProperty("org.omg.CORBA.ORBInitialHost", GLASSFISH_ORB_HOST);
        jNDIProperties.setProperty("org.omg.CORBA.ORBInitialPort", GLASSFISH_ORB_PORT);
        this.namingContext = new InitialContext(jNDIProperties);
    }

    private void retrieveRemoteServicesAdmin() throws NamingException {
        this.splacelibAdmin = (SpacelibAdminRemote) this.namingContext.lookup(SERVICES_ADMIN_EJB_URI);
    }

    public SpacelibAdminRemote getAdminRemoteSvc() {
        return splacelibAdmin;
    }
}
