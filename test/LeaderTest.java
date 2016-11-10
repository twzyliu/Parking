import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 10/11/16.
 */
public class LeaderTest {

    private static final int CAPACITY = 1;
    private Car car;
    private withParkingCapability fullParking;
    private withParkingCapability fullManager;

    @Before
    public void setUp() throws Exception {
        car = new Car(0);
        fullParking = new Parking(CAPACITY);
        fullParking.park(car);
        List<withParkingCapability> parkList = new ArrayList<>();
        parkList.add(fullParking);
        fullManager = new Manager(parkList, new DefaultSelector(parkList));
    }

    @Test
    public void should_return_false_when_leader_cannot_find_available_manager() throws Exception {
        List<withParkingCapability> managers = new ArrayList<>();
        managers.add(fullManager);
        withParkingCapability leader = new Manager(managers);
        assertThat(leader.isAvailable(), is(false));
        assertThat(leader.getAvailableParking() == null, is(true));
    }

    @Test
    public void should_return_available_parking_when_leader_can_find_available_manager() throws Exception {
        ArrayList<withParkingCapability> parkList = new ArrayList<>();
        parkList.add(new Parking(CAPACITY));
        ArrayList<withParkingCapability> managers = new ArrayList<>();
        withParkingCapability manager = new Manager(parkList, new DefaultSelector(parkList));
        managers.add(manager);
        managers.add(fullManager);
        withParkingCapability leader = new Manager(managers);
        assertThat(leader.isAvailable(), is(true));
        assertThat(leader.getAvailableParking(), is(manager.getAvailableParking()));
    }
}
