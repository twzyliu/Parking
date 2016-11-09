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
    public void car_cannot_come_in_when_three_parking_are_full() throws Exception {
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(fullParking);
        Manager manager = new Manager(parkList);
        assertThat(manager.canPark(), is(false));
        assertThat(manager.getAvailableParking() == null, is(true));
    }

    @Test
    public void car_can_come_in_parking_when_parking_is_empty() throws Exception {
        Parking parking = new Parking(CAPACITY);
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(parking);
        Manager manager = new Manager(parkList);
        assertThat(manager.canPark(), is(true));
        assertThat(manager.getAvailableParking(), is(parking));
    }

    @Test
    public void manager_can_help_park_car_when_parking_is_empty() throws Exception {
        Parking parking = new Parking(CAPACITY);
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(parking);
        Manager manager = new Manager(parkList);
        Parking emptyParking = manager.getAvailableParking();
        int space = emptyParking.getSpace();
        assertThat(manager.helpPark(emptyParking, car), is(true));
        assertThat(emptyParking.getSpace(), is(space - 1));
    }

    @Test
    public void manager_can_help_leave_car_when_car_is_in_parking() throws Exception {
        Parking parking = new Parking(CAPACITY);
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(parking);
        Manager manager = new Manager(parkList);
        Parking emptyParking = manager.getAvailableParking();
        manager.helpPark(emptyParking, car);
        int space = emptyParking.getSpace();
        assertThat(manager.helpLeave(emptyParking, car), is(true));
        assertThat(emptyParking.getSpace(), is(space + 1));
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
        Selector selector = new MoreSpaceSelector(parkList);
        Manager manager = new Manager(parkList, selector);
        assertThat(manager.canPark(), is(true));
        assertThat(manager.getAvailableParking(), is(parking2));
    }
}
