import java.util.List;

/**
 * Created by zyongliu on 09/11/16.
 */
class MoreSpaceSelector implements Selector{
    private List<Parking> parkingList;

    public MoreSpaceSelector(List<Parking> parkingList) {
        this.parkingList = parkingList;
    }

    @Override
    public Parking getAvailableParking() {
        Parking moreSpaceParking = parkingList.get(0);
        for (Parking parking : parkingList) {
            if (parking.getSpace() > moreSpaceParking.getSpace()) {
                moreSpaceParking = parking;
            }
        }
        return moreSpaceParking;
    }
}
