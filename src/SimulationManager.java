import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimulationManager {

    private final OrganismFactory organismFactory;
    private final Island island;
    private ScheduledExecutorService scheduledExecutorService;

    public SimulationManager() {
        organismFactory = new OrganismFactory();
        island = createIsland(10, 20);
        randomlySpreadOrganisms(createInitialOrganisms());
        scheduledExecutorService = Executors.newScheduledThreadPool(3);
    }

    public static void main(String[] args) {
        SimulationManager simulationManager = new SimulationManager();
        List<Organism> organismList = new ArrayList<>();
        for (int i = 0; i < simulationManager.island.verticalLength; i++) {
            for (int j = 0; j < simulationManager.island.horizontalLength ; j++) {
                Island.Tile tile = simulationManager.island.getTile(j, i);
                for (Class<?> clazz : tile.getOrganismMap().keySet()) {
                    for (Organism organism : tile.getOrganismMap().get(clazz)) {
                        simulationManager.scheduledExecutorService.schedule(organism, 10, TimeUnit.MILLISECONDS);
                    }
                }

            }
        }

        simulationManager.scheduledExecutorService.shutdown();
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
            organism.setInitialPosition(island, randomX, randomY);
        }
    }
}
