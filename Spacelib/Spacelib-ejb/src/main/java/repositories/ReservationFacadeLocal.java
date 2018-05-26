/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Navette;
import entities.Quai;
import entities.Reservation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jb
 */
@Local
public interface ReservationFacadeLocal {

    void create(Reservation reservation);

    void edit(Reservation reservation);

    void remove(Reservation reservation);

    Reservation find(Object id);

    List<Reservation> findAll();

    List<Reservation> findRange(int[] range);

    int count();
    
    void voyageAchevé(Reservation r);
    
    void voyageInitié(Reservation r);
    
    void quaiDepart(Reservation r, Quai quai);
    
    void quaiArrivee(Reservation r, Quai quai);
    
    
}
