import java.util.List;

/**
 * Created by zyongliu on 09/11/16.
 */
class DefaultSelector implements Selector {
    private List<withParkingCapability> parkingList;

    public DefaultSelector(List<withParkingCapability> parkingList) {
        this.parkingList = parkingList;
    }

    @Override
    public withParkingCapability getAvailableParking() {
        for (withParkingCapability parking : parkingList) {
            if (parking.isAvailable()) {
                return parking;
            }
        }
        return null;
    }
}