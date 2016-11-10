import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 09/11/16.
 */
public class ParkingTest {

    private static final int CAPACITY = 1;
    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car(0);
    }

    @Test
    public void car_can_come_in_when_parking_is_empty() throws Exception {
        withParkingCapability parking = new Parking(CAPACITY);
        assertThat(parking.getSpace(), is(CAPACITY));
        assertThat(parking.park(car), is(true));
        assertThat(parking.getSpace(), is(CAPACITY - 1));
    }

    @Test
    public void car_cannot_come_in_when_parking_isnot_empty() throws Exception {
        withParkingCapability parking = new Parking(CAPACITY);
        parking.park(car);
        assertThat(parking.getSpace(), is(0));
        assertThat(parking.park(car), is(false));
    }

    @Test
    public void car_can_come_out_when_parking_isnot_empty() throws Exception {
        withParkingCapability parking = new Parking(CAPACITY);
        parking.park(car);
        assertThat(parking.getSpace(), is(CAPACITY - 1));
        assertThat(parking.unpark(car), is(true));
        assertThat(parking.getSpace(), is(CAPACITY));
    }

    @Test
    public void car_cannot_come_out_when_parking_is_empty() throws Exception {
        withParkingCapability parking = new Parking(CAPACITY);
        assertThat(parking.unpark(car), is(false));
    }
}
