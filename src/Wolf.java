public class Wolf extends Animal {
    @Override
    public void run() {
        move(3);
        System.out.println(getClass().getSimpleName() + " " + this.hashCode() + ", X coordinate:" + getXCoordinate()+ ", Y coordinate:" + getYCoordinate());
    }
}
