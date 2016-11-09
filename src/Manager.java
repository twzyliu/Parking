import java.util.ArrayList;

/**
 * Created by zyongliu on 09/11/16.
 */
public class Manager {
    private ArrayList<Parking> parkList;
    private Selector selector;

    public Manager(ArrayList<Parking> parkList) {
        this.parkList = parkList;
        this.selector = new DefaultSelector(parkList);
    }

    public Manager(ArrayList<Parking> parkList, Selector selector) {
        this.parkList = parkList;
        this.selector = selector;
    }

    public boolean canPark() {
        boolean isFull = false;
        for (Parking parking : parkList) {
            isFull |= parking.getSpace() > 0;
        }
        return isFull;
    }

    public Parking getAvailableParking() {
        return selector.getAvailableParking();
    }

    public boolean helpPark(Parking availableParking, Car car) {
        return availableParking.carComeIn(car);
    }

    public boolean helpLeave(Parking availableParking, Car car) {
        return availableParking.carComeOut(car);
    }
}
