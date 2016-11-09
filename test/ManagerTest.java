import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 09/11/16.
 */
public class ManagerTest {

    public static final int CAPACITY = 2;
    private Car car;
    private Parking fullParking;

    @Before
    public void setUp() throws Exception {
        car = new Car(0);
        fullParking = new Parking(CAPACITY);
        fullParking.carComeIn(car);
        fullParking.carComeIn(car);
    }

    @Test
    public void manager_should_find_parking_which_has_more_space() throws Exception {
        Parking parking1 = new Parking(CAPACITY);
        Parking parking2 = new Parking(CAPACITY);
        parking1.carComeIn(car);
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(parking1);
        parkList.add(parking2);
        parkList.add(fullParking);
        Manager manager = new Manager(parkList);
        assertThat(manager.canPark(), is(true));
        assertThat(manager.findParking(), is(parking2));
    }

    @Test
    public void manager_cannot_park_car_when_all_parking_are_full() throws Exception {
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(fullParking);
        Manager manager = new Manager(parkList);
        assertThat(manager.canPark(), is(false));
    }

}
