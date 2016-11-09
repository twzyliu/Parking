import java.util.ArrayList;

/**
 * Created by zyongliu on 09/11/16.
 */
public class Assistant {
    private ArrayList<Parking> parkList;

    public Assistant(ArrayList<Parking> parkList) {
        this.parkList = parkList;
    }

    public boolean canPark() {
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

    public boolean helpPark(Parking emptyParking, Car car) {
        return emptyParking.carComeIn(car);
    }

    public boolean helpLeave(Parking emptyParking, Car car) {
        return emptyParking.carComeOut(car);
    }
}