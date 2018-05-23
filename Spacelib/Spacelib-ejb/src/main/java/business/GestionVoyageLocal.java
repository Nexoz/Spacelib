/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entities.Navette;
import entities.Quai;
import entities.Reservation;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface GestionVoyageLocal {
    void finaliserVoyage(Navette navette, Reservation reservation, Quai quai);
    void reserverNavette (Navette navette, Reservation reservetion, Quai quaiDepart);
}
