import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism {
    public int chooseNextXCoordinate() {
        return ThreadLocalRandom.current().nextInt(getXCoordinate() - 1 >= 0 ? getXCoordinate() - 1 : getXCoordinate(), getXCoordinate() + 1 < getIsland().horizontalLength ? getXCoordinate() + 2 : getXCoordinate() + 1);
    }
    public int chooseNextYCoordinate() {
        return ThreadLocalRandom.current().nextInt(getYCoordinate() - 1 >= 0 ? getYCoordinate() - 1 : getYCoordinate(), getYCoordinate() + 1 < getIsland().verticalLength ? getYCoordinate() + 2 : getYCoordinate() + 1);
    }

    public void move(int tileCount) {
        for (int i = 0; i < tileCount; i++) {
            int nextXCoordinate = chooseNextXCoordinate();
            int nextYCoordinate = chooseNextYCoordinate();
            //System.out.println(this.hashCode() + ", next coordinates : " + ("X:" + nextXCoordinate + ",Y:" + nextYCoordinate));
            boolean successfull = changePosition(nextXCoordinate, nextYCoordinate);
            if (!successfull) {
                tileCount--;
            }
        }
    }

}
