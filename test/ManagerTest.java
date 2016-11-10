import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 09/11/16.
 */
public class ManagerTest {

    private static final int CAPACITY = 2;
    private Car car;
    private withParkingCapability fullParking;

    @Before
    public void setUp() throws Exception {
        car = new Car(0);
        fullParking = new Parking(CAPACITY);
        fullParking.park(car);
        fullParking.park(car);
    }

    @Test
    public void car_cannot_come_in_when_three_parking_are_full() throws Exception {
        ArrayList<withParkingCapability> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(fullParking);
        withParkingCapability manager = new Manager(parkList, new DefaultSelector(parkList));
        assertThat(manager.isAvailable(), is(false));
        assertThat(manager.getAvailableParking() == null, is(true));
    }

    @Test
    public void car_can_come_in_parking_when_parking_is_empty() throws Exception {
        withParkingCapability parking = new Parking(CAPACITY);
        ArrayList<withParkingCapability> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(parking);
        withParkingCapability manager = new Manager(parkList, new DefaultSelector(parkList));
        assertThat(manager.isAvailable(), is(true));
        assertThat(manager.getAvailableParking(), is(parking));
    }

    @Test
    public void manager_can_help_park_car_when_parking_is_empty() throws Exception {
        withParkingCapability parking = new Parking(CAPACITY);
        ArrayList<withParkingCapability> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(parking);
        withParkingCapability manager = new Manager(parkList, new DefaultSelector(parkList));
        withParkingCapability emptyParking = manager.getAvailableParking();
        int space = emptyParking.getSpace();
        assertThat(manager.park(car), is(true));
        assertThat(emptyParking.getSpace(), is(space - 1));
    }

    @Test
    public void manager_can_help_leave_car_when_car_is_in_parking() throws Exception {
        withParkingCapability parking = new Parking(CAPACITY);
        ArrayList<withParkingCapability> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(parking);
        withParkingCapability manager = new Manager(parkList, new DefaultSelector(parkList));
        withParkingCapability emptyParking = manager.getAvailableParking();
        manager.park(car);
        int space = emptyParking.getSpace();
        assertThat(manager.unpark(car), is(true));
        assertThat(emptyParking.getSpace(), is(space + 1));
    }

    @Test
    public void manager_should_find_parking_which_has_more_space() throws Exception {
        withParkingCapability parking1 = new Parking(CAPACITY);
        withParkingCapability parking2 = new Parking(CAPACITY);
        parking1.park(car);
        ArrayList<withParkingCapability> parkList = new ArrayList<>();
        parkList.add(parking1);
        parkList.add(parking2);
        parkList.add(fullParking);
        Selector selector = new MoreSpaceSelector(parkList);
        withParkingCapability manager = new Manager(parkList, selector);
        assertThat(manager.isAvailable(), is(true));
        assertThat(manager.getAvailableParking(), is(parking2));
    }

    @Test
    public void manager_should_find_parking_which_has_more_percentage_space() throws Exception {
        withParkingCapability parking1 = new Parking(CAPACITY + 100);
        withParkingCapability parking2 = new Parking(CAPACITY);
        parking1.park(car);
        ArrayList<withParkingCapability> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(parking1);
        parkList.add(parking2);
        Selector selector = new MorePercentageSelector(parkList);
        withParkingCapability manager = new Manager(parkList, selector);
        assertThat(manager.isAvailable(), is(true));
        assertThat(manager.getAvailableParking(), is(parking2));
    }
}
