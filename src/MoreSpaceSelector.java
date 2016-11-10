import java.util.List;

/**
 * Created by zyongliu on 09/11/16.
 */
class MoreSpaceSelector implements Selector{
    private List<withParkingCapability> parkingList;

    public MoreSpaceSelector(List<withParkingCapability> parkingList) {
        this.parkingList = parkingList;
    }

    @Override
    public withParkingCapability getAvailableParking() {
        withParkingCapability moreSpaceParking = parkingList.get(0);
        for (withParkingCapability parking : parkingList) {
            if (parking.getSpace() > moreSpaceParking.getSpace()) {
                moreSpaceParking = parking;
            }
        }
        return moreSpaceParking;
    }
}
