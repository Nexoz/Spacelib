/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.toulouse.miage.borneclient.services;

import fr.miage.toulouse.spacelibshared.RMI.SpacelibBorneRemote;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author pierreliaubet
 */
public class RMIBorneServiceManager {
    private final static String GLASSFISH_ORB_HOST = "localhost";
    private final static String GLASSFISH_ORB_PORT = "3700";
    private final static String SERVICES_BORNE_EJB_URI = "java:global/Spacelib-ear/Spacelib-ejb-1.0-SNAPSHOT/ServiceBorneRMI!fr.miage.toulouse.spacelibshared.RMI.SpacelibBorneRemote";

    private InitialContext namingContext;
    private SpacelibBorneRemote splacelibBorne;

    public RMIBorneServiceManager() throws NamingException {
        this.initJndi();
        this.retrieveRemoteServicesBorne();
    }

    private void initJndi() throws NamingException {
        Properties jNDIProperties = new Properties();
        jNDIProperties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        jNDIProperties.setProperty("org.omg.CORBA.ORBInitialHost", GLASSFISH_ORB_HOST);
        jNDIProperties.setProperty("org.omg.CORBA.ORBInitialPort", GLASSFISH_ORB_PORT);
        this.namingContext = new InitialContext(jNDIProperties);
    }

    private void retrieveRemoteServicesBorne() throws NamingException {
        this.splacelibBorne = (SpacelibBorneRemote) this.namingContext.lookup(SERVICES_BORNE_EJB_URI);
    }

    public SpacelibBorneRemote getBorneRemoteSvc() {
        return splacelibBorne;
    }
}
