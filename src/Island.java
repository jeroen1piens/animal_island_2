import java.util.*;

public class Island {
    private final Tile[][] tilesGrid;
    public final int horizontalLength;
    public final int verticalLength;

    public Island(int horizontalLength, int verticalLength) {
        this.horizontalLength = horizontalLength;
        this.verticalLength = verticalLength;

        tilesGrid = new Tile[verticalLength][horizontalLength];
        for (int i = 0; i < tilesGrid.length; i++) {
            for (int j = 0; j < tilesGrid[i].length; j++) {
                tilesGrid[i][j] = new Tile();
            }
        }
    }
    public boolean addOrganism(Organism organism, int xPosition, int yPosition) {
        Tile tile = tilesGrid[yPosition][xPosition];
        synchronized (tile) {
            if (tile.isFull(organism)) {
                return false;
            }
            else if (tile.organismMap.containsKey(organism.getClass())) {
                tile.organismMap.get(organism.getClass()).add(organism);
                return true;
            }
            else {
                tile.organismMap.put(organism.getClass(), new HashSet<>());
                tile.organismMap.get(organism.getClass()).add(organism);
                return true;
            }
        }
    }

    public void removeOrganism(Organism organism, int xCoordinate, int yCoordinate) {
        Tile tile = tilesGrid[yCoordinate][xCoordinate];
        tile.organismMap.get(organism.getClass()).remove(organism);
    }

    public class Tile{
        /*
        public Map<Class<? extends Organism>, Set<Organism>> getOrganismMap() {
            return organismMap;
        }
        */

        private Map<Class<? extends Organism>, Set<Organism>> organismMap = new HashMap<>();
        private static final Map<String, Integer> maxCapacityMap = new HashMap<>() {
            {this.put("Plant", 100);
            this.put("Wolf", 5);}
        };

        public Tile() {
        }

        public boolean isFull(Organism organism) {
            if(!organismMap.containsKey(organism.getClass())) {
                return false;
            }
            else if (organismMap.get(organism.getClass()).size() >= maxCapacityMap.get(organism.getClass().getSimpleName())) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
