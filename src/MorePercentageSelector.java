import java.util.List;

/**
 * Created by zyongliu on 09/11/16.
 */
public class MorePercentageSelector implements Selector {
    private List<Parking> parkingList;

    public MorePercentageSelector(List<Parking> parkingList) {
        this.parkingList = parkingList;
    }

    @Override
    public Parking getAvailableParking() {
        Parking morePercentageParking = parkingList.get(0);
        for (Parking parking : parkingList) {
            if (parking.getSpacePercentage() > morePercentageParking.getSpacePercentage()) {
                morePercentageParking = parking;
            }
        }
        return morePercentageParking;
    }
}
