import java.util.ArrayList;
import java.util.Collection;
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

    }

    public static void main(String[] args) {
        SimulationManager simulationManager = new SimulationManager();
        simulationManager.simulate(100);
    }

    public void scheduleNextTurn(Collection<Organism> organisms, ScheduledExecutorService scheduledExecutorService) {
        for (Organism organism : organisms) {
            scheduledExecutorService.schedule(organism, 10, TimeUnit.MILLISECONDS);
        }
    }

    public void simulate(int turns) {
        for (int i = 0; i < turns; i++) {
            scheduledExecutorService = Executors.newScheduledThreadPool(3);
            scheduleNextTurn(island.retrieveAllOrganisms(), scheduledExecutorService);
            scheduledExecutorService.shutdown();
            while(!scheduledExecutorService.isTerminated()) {
                try{
                    Thread.sleep(250);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(island.retrieveAllOrganisms());
            System.out.println("Organisms count: " + island.retrieveAllOrganisms().size());
        }
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
