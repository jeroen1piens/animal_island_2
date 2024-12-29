import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationManager {

    private final OrganismFactory organismFactory;
    private final Island island;

    public SimulationManager() {
        organismFactory = new OrganismFactory();
        island = createIsland(10, 20);
        randomlySpreadOrganisms(createInitialOrganisms());
    }

    public static void main(String[] args) {
        SimulationManager simulationManager = new SimulationManager();
        /*
        for (int i = 0; i < simulationManager.island.getTilesGrid().length; i++) {
            for (int j = 0; j < simulationManager.island.getTilesGrid()[0].length; j++) {
                System.out.println(simulationManager.island.getTilesGrid()[i][j].getOrganismMap());
            }
        }
        */
    }

    public Island createIsland(int horizontalLength, int verticalLength) {
        return new Island(horizontalLength, verticalLength);
    }

    public List<Organism> createInitialOrganisms() {
        List<Organism> initialOrganisms = new ArrayList<>();
        initialOrganisms.addAll(organismFactory.createPlants(100));
        initialOrganisms.addAll(organismFactory.createWolfs(100));
        return initialOrganisms;
    }

    public void randomlySpreadOrganisms(List<Organism> organisms) {
        Random random = new Random();
        int randomX;
        int randomY;
        for (Organism organism : organisms) {
            randomX = random.nextInt(0, island.horizontalLength);
            randomY = random.nextInt(0, island.verticalLength);
            organism.setPosition(randomX, randomY);
            organism.setIsland(island);
            island.addOrganism(organism, organism.getXCoordinate(), organism.getYCoordinate());
        }
    }
}
