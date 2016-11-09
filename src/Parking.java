import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyongliu on 09/11/16.
 */
public class Parking {
    private List<Car> carList = new ArrayList<>();
    private int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
    }

    public boolean carComeIn(Car myCar) {
        if (getSpace() > 0) {
            carList.add(myCar);
            return true;
        } else {
            return false;
        }
    }

    public boolean carComeOut(Car myCar) {
        if (!carList.isEmpty() & carList.indexOf(myCar) > -1) {
            carList.remove(myCar);
            return true;
        } else {
            return false;
        }
    }

    public int getSpace() {
        return capacity - carList.size();
    }

    public double getSpacePercentage() {
        return getSpace() / capacity;
    }
}
