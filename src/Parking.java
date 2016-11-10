import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyongliu on 09/11/16.
 */
public class Parking implements withParkingCapability {
    private List<Car> carList = new ArrayList<>();

    public int getCapacity() {
        return capacity;
    }

    private int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean park(Car myCar) {
        if (getSpace() > 0) {
            carList.add(myCar);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean unpark(Car myCar) {
        if (!carList.isEmpty() & carList.indexOf(myCar) > -1) {
            carList.remove(myCar);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getSpace() {
        return capacity - carList.size();
    }

    @Override
    public double getSpacePercentage() {
        return getSpace() / capacity;
    }

    @Override
    public boolean isAvailable() {
        return getSpace() > 0;
    }

    @Override
    public withParkingCapability getAvailableParking() {
        if (isAvailable()) {
            return this;
        } else {
            return null;
        }
    }

    @Override
    public String play(String space) {
        return new Report(space).printParkinglot(getSpace(),capacity);
    }


}
