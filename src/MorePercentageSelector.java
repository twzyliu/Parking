import java.util.List;

/**
 * Created by zyongliu on 09/11/16.
 */
class MorePercentageSelector implements Selector {
    private List<withParkingCapability> parkingList;

    public MorePercentageSelector(List<withParkingCapability> parkingList) {
        this.parkingList = parkingList;
    }

    @Override
    public withParkingCapability getAvailableParking() {
        withParkingCapability morePercentageParking = parkingList.get(0);
        for (withParkingCapability parking : parkingList) {
            if (parking.getSpacePercentage() > morePercentageParking.getSpacePercentage()) {
                morePercentageParking = parking;
            }
        }
        return morePercentageParking;
    }
}
