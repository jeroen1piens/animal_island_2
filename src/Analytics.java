import java.util.*;

public class Analytics {
    private Collection<Organism> allOrganismsCollection;
    private Set<Plant> allPlantsSet = new HashSet<>();
    private Set<Wolf> allWolfsSet = new HashSet<>();


    public Analytics() {
    }

    public void setAllOrganismsCollection(Collection<Organism> allOrganismsCollection) {
        this.allOrganismsCollection = allOrganismsCollection;
    }
    private void updateAllSets() {
        for (Organism organism : allOrganismsCollection) {
            switch(organism.getClass().getSimpleName()) {
                case "Plant" -> allPlantsSet.add((Plant) organism);
                case "Wolf" -> allWolfsSet.add((Wolf) organism);
            }
        }
    }

    public Map<String, Integer> getOrganismsCountMap() {
        Map<String, Integer> organismsCountMap = new HashMap<>();
        updateAllSets();
        organismsCountMap.put("Total Organisms", allOrganismsCollection.size());
        organismsCountMap.put("Plants", allPlantsSet.size());
        organismsCountMap.put("Wolfs", allWolfsSet.size());
        return organismsCountMap;
    }

}
