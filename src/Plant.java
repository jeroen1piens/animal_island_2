public class Plant extends Organism {
    @Override
    public void run() {
        System.out.println(getClass().getSimpleName() + " " + this.hashCode() + ", X coordinate:" + getXCoordinate()+ ", Y coordinate:" + getYCoordinate());
    }
}
