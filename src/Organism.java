public abstract class Organism {

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
    public void setIsland(Island island) {
        this.island = island;
    }

    public boolean setPosition(int newXCoordinate, int newYCoordinate) {
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
