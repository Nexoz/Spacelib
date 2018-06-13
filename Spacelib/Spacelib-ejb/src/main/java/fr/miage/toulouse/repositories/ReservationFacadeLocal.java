/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.repositories;

import fr.miage.toulouse.entities.Navette;
import fr.miage.toulouse.entities.Quai;
import fr.miage.toulouse.entities.Reservation;
import fr.miage.toulouse.entities.Usager;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 * Interface de la façade des réservations
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
    
     /**
     * Marque la fin d'un voyage
     * @param r Réservation conercnée
     */
    void voyageAchevé(Reservation r);
    
    /**
     * Marque le début d'un voyage
     * @param r Réservation conercnée
     */
    void voyageInitié(Reservation r);
    
    /**
     * Ajout du quai de départ à la réservation
     * @param r réservation
     * @param quai quai de départ
     */
    void quaiDepart(Reservation r, Quai quai);
    
    /**
     * Ajout du quai d'arrivé à la réservation
     * @param r réservation
     * @param quai quai d'arrivé
     */
    void quaiArrivee(Reservation r, Quai quai);
   

    /**
     * Création d'une réservation
     * @param voyage_initié libellé de la réservation
     * @param quaiD quai de départ du voyage
     * @param quaiA quai d'arrivé du voyage
     * @param idEmprunteur id de l'usager 
     * @param nbPassager nombre de passager du voyage
     * @param navDisponible navette utilisée pour le voyage
     * @param dateOpe date de la création de l'opération
     * @param dateDebut date de début de l'opératon
     * @return 
     */
    Reservation creerReservation(String voyage_initié, Quai quaiD, Quai quaiA, Usager idEmprunteur, int nbPassager, Navette navDisponible, Date dateOpe, Date dateDebut);
    
    
}
