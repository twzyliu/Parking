import java.util.List;

/**
 * Created by zyongliu on 09/11/16.
 */
class DefaultSelector implements Selector{
    private List<Parking> parkingList;

    public DefaultSelector(List<Parking> parkingList) {
        this.parkingList = parkingList;
    }

    @Override
    public Parking getAvailableParking() {
        for (Parking parking : parkingList) {
            if (parking.getSpace() > 0) {
                return parking;
            }
        }
        return null;
    }
}