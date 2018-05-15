/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Navette;
import entities.Quai;
import entities.Station;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jb
 */
@Stateless
public class StationFacade extends AbstractFacade<Station> implements StationFacadeLocal {

    
    
    @PersistenceContext(unitName = "spacelibPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StationFacade() {
        super(Station.class);
    }
    
    @Override
    public List<Station> getAllStations(){
        return findAll();
    }
    
    @Override
    public void ajouterQuai(Station station,Quai q){
        station.getListeQuais().add(q);
    }
    
    @Override
    public int getTempsTrajet(Station station){
        return 0;
    }
    
 /*   @Override
    public List<Navette> getNavetteAReviser(Station station){
        List<Navette> navProblem = new ArrayList<>();
        for (Quai q : station.getListeQuais()){
            if(hasNavette(q)){
                if(q.getNavArrimée().getProchaineRevision()==1){
                    navProblem.add(q.getNavArrimée());
                }
            }
        }     
        return navProblem;
    }*/
    
}
