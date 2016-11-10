import java.util.List;

/**
 * Created by zyongliu on 09/11/16.
 */
public class Manager implements withParkingCapability {
    private List<withParkingCapability> parkList;
    private Selector selector;

    @Override
    public int getCapacity() {
        return getAvailableParking().getCapacity();
    }

    private int capacity;

    public Manager(List<withParkingCapability> parkList, Selector selector) {
        this.parkList = parkList;
        this.selector = selector;
    }

    public Manager(List<withParkingCapability> parkList) {
        this.parkList = parkList;
        this.selector = null;
    }

    @Override
    public boolean park(Car myCar) {
        return getAvailableParking().park(myCar);
    }

    @Override
    public boolean unpark(Car myCar) {
        return getAvailableParking().unpark(myCar);
    }

    @Override
    public int getSpace() {
        return getAvailableParking().getSpace();
    }

    @Override
    public double getSpacePercentage() {
        return getAvailableParking().getSpacePercentage();
    }

    @Override
    public boolean isAvailable() {
        boolean isFull = false;
        for (withParkingCapability parking : parkList) {
            isFull |= parking.isAvailable();
        }
        return isFull;
    }

    @Override
    public withParkingCapability getAvailableParking() {
        if (selector == null) {
            for (withParkingCapability w : parkList) {
                if (w.isAvailable()) {
                    return w.getAvailableParking();
                }
            }
        } else {
            return selector.getAvailableParking();
        }
        return null;
    }

    @Override
    public String play(String space) {
        return new Report(space).printParker(parkList);
    }

}
