import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 09/11/16.
 */
public class ManagerTest {

    public static final int CAPACITY = 2;

    @Test
    public void manager_should_find_parking_which_has_more_space() throws Exception {
        Parking parking1 = new Parking(CAPACITY);
        Parking parking2 = new Parking(CAPACITY);
        Parking parking3 = new Parking(CAPACITY);
        parking1.carComeIn(new Car(0));
        parking2.carComeIn(new Car(1));
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(parking1);
        parkList.add(parking2);
        parkList.add(parking3);
        Manager manager = new Manager(parkList);
        assertThat(manager.canPark(), is(true));
        assertThat(manager.findParking(), is(parking3));
    }

    @Test
    public void manager_cannot_park_car_when_all_parking_are_full() throws Exception {
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(new Parking(CAPACITY));
        parkList.add(new Parking(CAPACITY));
        parkList.add(new Parking(CAPACITY));
        Manager manager = new Manager(parkList);
        assertThat(manager.canPark(), is(false));
    }

}
