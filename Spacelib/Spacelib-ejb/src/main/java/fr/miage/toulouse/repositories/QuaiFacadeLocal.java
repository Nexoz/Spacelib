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

    void create(Quai quai);

    void edit(Quai quai);

    void remove(Quai quai);

    Quai find(Object id);

    List<Quai> findAll();

    List<Quai> findRange(int[] range);

    int count();
    
    void arrimer(Quai quai, Navette navette);
    
    void desarrimer(Quai quai);
    
    boolean hasNavette(Quai quai);
    
    Navette getNavette(Quai quai);
    
    boolean isDisponible(Quai quai);

    public void reserverQuai(Quai quaiA, Date dateA);
    
}
