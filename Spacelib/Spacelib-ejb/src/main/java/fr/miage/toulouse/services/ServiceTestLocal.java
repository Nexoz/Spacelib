/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.services;

import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface ServiceTestLocal {
    
    void createStation(String name);
}
