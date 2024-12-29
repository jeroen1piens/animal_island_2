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
    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    public void setIsland(Island island) {
        this.island = island;
    }

    public boolean setPosition(int x, int y) {
        boolean successful = island.addOrganism(this, x, y);
        if (successful) {
            island.removeOrganism(this);
            this.setXCoordinate(x);
            this.setYCoordinate(y);
            return true;
        }
        else {
            return false;
        }
    }

}
