/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface QuaiFacadeLocal {

    /**
     * création d'une entité de quai 
     * @param quai Quai à créer 
     */
    void create(Quai quai);

    /**
     * modification d'un quai
     * @param quai Quai à modifier 
     */
    void edit(Quai quai);

    /**
     * suppression d'un quai 
     * @param quai Quai à supprimer
     */
    void remove(Quai quai);

    /***
     * retourne un quai 
     * @param id quai qu'on recherche 
     * @return 
     */
    Quai find(Object id);

    /**
     * retourne les entités de quai 
     * @return List<Quai> liste des quais 
     */
    List<Quai> findAll();

    /**
     * 
     * @param range
     * @return 
     */
    List<Quai> findRange(int[] range);

    /**
     * retourne le nombre de quais 
     * @return 
     */
    int count();
    
    /**
     * Arrime une navette à un quai 
     * @param quai quai sur lequel on veut arrimer la navette 
     * @param navette navette qu'on arrime au quai 
     */
    void arrimer(Quai quai, Navette navette);
    
    /**
     * désarrime une navette qu'un quai 
     * @param quai quai où on désarrime la navette 
     */
    void desarrimer(Quai quai);
    
    /**
     * Donne l'information si une navette est arrimée à un quai 
     * @param quai quai sur lequel on veut avoir l'information 
     * @return true si une navette est arrimée, false sinon 
     */
    boolean hasNavette(Quai quai);
    
    /**
     * retourne la navette arrimée à un quai 
     * @param quai quai sur lequel on veut la navette 
     * @return la Navette arrimée au quai 
     */
    Navette getNavette(Quai quai);
    
    /**
     * Donne l'information si un quai est disponible
     * @param quai Quai sur lequel on veut avoir l'information 
     * @return true si le quai est disponible, false sinon 
     */
    boolean isDisponible(Quai quai);

    /**
     * reserve un quai à une date 
     * @param quaiA Quai qu'on veut réserver 
     * @param dateA Date à laquelle on veut réserver le quai 
     */
    public void reserverQuai(Quai quaiA, Date dateA);
    
}
