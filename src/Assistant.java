import java.util.ArrayList;

/**
 * Created by zyongliu on 09/11/16.
 */
public class Assistant {
    private ArrayList<Parking> parkList;

    public Assistant(ArrayList<Parking> parkList) {
        this.parkList = parkList;
    }

    public boolean canComeIn() {
        boolean isFull = false;
        for (Parking parking : parkList) {
            isFull |= parking.getSpace() > 0;
        }
        return isFull;
    }

    public Parking getEmptyParking() {
        for (Parking parking : parkList) {
            if (parking.getSpace() > 0) {
                return parking;
            }
        }
        return null;
    }

    public void helpPark(Parking emptyParking, Car car) {
        emptyParking.carComeIn(car);
    }

    public void helpLeave(Parking emptyParking, Car car) {
        emptyParking.carComeOut(car);
    }
}