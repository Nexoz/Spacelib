package fr.miage.toulouse.spacelibshared;

import java.util.HashMap;
import java.util.Map;

public class DistancesCalculator {

    private static DistancesCalculator inst = null;
    
    private Map<String, Map<String, Integer>> distances = null;

    private final String[] stations = {"Terre", "Dimidium", "Arion", "Brahe", "Amateru", "Tadmor"};
    private final int[] distTerre = {0,2,6,2,4,2};
    private final int[] distDimidium = {2,0,6,4,6,4};
    private final int[] distArion = {6,6,0,6,8,6};
    private final int[] distBrahe = {2,4,6,0,4,2};
    private final int[] distAmateru = {4,6,8,4,0,2};
    private final int[] distTadmor = {2,4,6,2,2,0};

    // Private car Singleton
    private DistancesCalculator() {
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

    // Méthode pour récupérer le singleton
    public static synchronized DistancesCalculator getInstance() {
        if(inst == null)
            inst = new DistancesCalculator();
        return inst;
    }

    public Integer calculerDistance(String s1, String s2) {
        Map<String, Integer> m = this.distances.get(s1);
        return m.get(s2);   
    }
    
    public static void main(String[] args) {
        System.out.println("" + DistancesCalculator.getInstance().calculerDistance("Terre", "Terre"));
    }
}