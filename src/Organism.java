public abstract class Organism implements Runnable {

    private Island island;
    private int xCoordinate;
    private int yCoordinate;

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }
    public Island getIsland() {
        return island;
    }

    public boolean setInitialPosition(Island island, int newXCoordinate, int newYCoordinate) {
        this.island = island;
        boolean successful = island.addOrganism(this, newXCoordinate, newYCoordinate);
        if (successful) {
            this.xCoordinate = newXCoordinate;
            this.yCoordinate = newYCoordinate;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean changePosition(int newXCoordinate, int newYCoordinate) {
        boolean successful = island.addOrganism(this, newXCoordinate, newYCoordinate);
        if (successful) {
            island.removeOrganism(this, this.xCoordinate, this.yCoordinate);
            this.xCoordinate = newXCoordinate;
            this.yCoordinate = newYCoordinate;
            return true;
        }
        else {
            return false;
        }
    }

}
