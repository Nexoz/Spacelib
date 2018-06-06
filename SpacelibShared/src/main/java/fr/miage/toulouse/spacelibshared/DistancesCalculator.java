package fr.miage.toulouse.spacelibshared;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton avec lazy loading permettant le calcul de distance entre deux stations
 * @author jb
 */
public class DistancesCalculator {

    /**
     * Instance du singleton
     */
    private static DistancesCalculator inst = null;
    
    /**
     * Stockage en cache des différentes distances entre station
     */
    private Map<String, Map<String, Integer>> distances = null;

    // Données de l'annexe sur les distances
    private final String[] stations = {"Terre", "Dimidium", "Arion", "Brahe", "Amateru", "Tadmor"};
    private final int[] distTerre = {0,2,6,2,4,2};
    private final int[] distDimidium = {2,0,6,4,6,4};
    private final int[] distArion = {6,6,0,6,8,6};
    private final int[] distBrahe = {2,4,6,0,4,2};
    private final int[] distAmateru = {4,6,8,4,0,2};
    private final int[] distTadmor = {2,4,6,2,2,0};

    // Private car Singleton
    private DistancesCalculator() {
        // Création d'un "tableau à deux dimensions" portant les données de l'annexe sur les distances
        int[][] dists = {distTerre, distDimidium, distArion, distBrahe, distAmateru, distTadmor};
        this.distances = new HashMap<>();
        for(int i = 0; i < 5; i++) {
            Map<String, Integer> infos = new HashMap<>();
            int[] diststation = dists[i];
            for(int j = 0; j < 5; j++) {
                infos.put(stations[j], diststation[j]);
            }
            this.distances.put(stations[i], infos);
        }
    }

    /**
     * Méthode permettant de retourner l'instance du Singleton
     * @return Instance du Singleton
     */
    public static synchronized DistancesCalculator getInstance() {
        if(inst == null)
            inst = new DistancesCalculator();
        return inst;
    }

    /**
     * Calcul de la distance en nombre de jours entre la station 1 et 2
     * @param s1 Nom de la station 1
     * @param s2 Nom de la station 2
     * @return Nombre de jours nécessaires pour aller de la station 1 à la station 2
     */
    public Integer calculerDistance(String s1, String s2) {
        Map<String, Integer> m = this.distances.get(s1);
        return m.get(s2);   
    }
}