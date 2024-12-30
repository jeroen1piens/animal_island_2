public class Wolf extends Animal {

    public final int id;
    private static int count = 0;

    public Wolf() {
        id = count;
        count++;
    }


    @Override
    public void run() {
        move(3);
        if (id == 0) {
            System.out.println(getClass().getSimpleName() + " " + this.hashCode() + ",(X:" + getXCoordinate()+ " , Y:" + getYCoordinate() + ")");
        }

    }
}
