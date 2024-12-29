import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism {
    public int chooseNextXPosition() {
        return ThreadLocalRandom.current().nextInt(getXCoordinate() - 1 >= 0 ? getXCoordinate() - 1 : getXCoordinate(), getXCoordinate() + 1 < getIsland().horizontalLength ? getXCoordinate() + 2 : getXCoordinate() + 1);
    }
    public int chooseNextYPosition() {
        return ThreadLocalRandom.current().nextInt(getYCoordinate() - 1 >= 0 ? getYCoordinate() - 1 : getYCoordinate(), getYCoordinate() + 1 < getIsland().verticalLength ? getYCoordinate() + 2 : getYCoordinate() + 1);
    }



}
