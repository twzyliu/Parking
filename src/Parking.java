import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyongliu on 09/11/16.
 */
public class Parking {
    private boolean isEmpty;
    private List<Car> carList;
    private int quantity;

    private static final int Max = 9;

    public Parking(boolean isEmpty) {
        this.isEmpty = isEmpty;
        this.quantity = 0;
        carList = new ArrayList<Car>();
    }

    public boolean canComeIn() {
        return isEmpty;
    }

    public void carComeIn(Car myCar) {
        if (canComeIn()) {
            carList.add(myCar);
            quantity += 1;
            checkStatus();
        }
    }

    public boolean canComeOut() {
        return quantity > 0;
    }

    public void carComeOut(Car myCar) {
        if (canComeOut()) {
            carList.remove(myCar);
            quantity -= 1;
        }
    }

    public void checkStatus() {
        isEmpty = quantity < Max;
    }

    public int getSpace() {
        return Max - quantity;
    }
}
