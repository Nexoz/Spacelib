/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import fr.miage.toulouse.business.GestionStation;
import fr.miage.toulouse.business.GestionStationLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jb
 */
@Stateless
public class ServiceTest implements ServiceTestLocal {

    @EJB
    private GestionStationLocal gestStation;
    
    @Override
    public void createStation(String name) {
        gestStation.ajouterStation(name, "");
    }
}
