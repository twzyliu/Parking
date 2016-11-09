import java.util.ArrayList;

/**
 * Created by zyongliu on 09/11/16.
 */
public class Manager {
    private ArrayList<Parking> parkList;

    public Manager(ArrayList<Parking> parkList) {
        this.parkList = parkList;
    }

    public Parking findParking() {
        Parking moreSpaceParking = parkList.get(0);
        for (Parking parking : parkList) {
            if (parking.getSpace() > moreSpaceParking.getSpace()) {
                moreSpaceParking = parking;
            }
        }
        return moreSpaceParking;
    }

    public boolean canPark() {
        boolean isFull = false;
        for (Parking parking : parkList) {
            isFull |= parking.getSpace() > 0;
        }
        return isFull;
    }
}
