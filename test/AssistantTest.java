import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 09/11/16.
 */
public class AssistantTest {

    public static final int CAPACITY = 1;
    private Car car;
    private Parking fullParking;

    @Before
    public void setUp() throws Exception {
        car = new Car(0);
        fullParking = new Parking(CAPACITY);
        fullParking.carComeIn(car);
    }

    @Test
    public void car_cannot_come_in_when_three_parking_are_full() throws Exception {
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(fullParking);
        Assistant assistant = new Assistant(parkList);
        assertThat(assistant.canPark(), is(false));
    }

    @Test
    public void car_can_come_in_parking_when_parking_is_empty() throws Exception {
        Parking parking = new Parking(CAPACITY);
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(parking);
        Assistant assistant = new Assistant(parkList);
        assertThat(assistant.canPark(), is(true));
        assertThat(assistant.getEmptyParking(), is(parking));
    }

    @Test
    public void assistant_can_help_park_car_when_parking_is_empty() throws Exception {
        Parking parking = new Parking(CAPACITY);
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(parking);
        Assistant assistant = new Assistant(parkList);
        Parking emptyParking = assistant.getEmptyParking();
        int space = emptyParking.getSpace();
        assertThat(assistant.helpPark(emptyParking, car), is(true));
        assertThat(emptyParking.getSpace(), is(space - 1));
    }

    @Test
    public void assistant_can_help_leave_car_when_car_is_in_parking() throws Exception {
        Parking parking = new Parking(CAPACITY);
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(fullParking);
        parkList.add(fullParking);
        parkList.add(parking);
        Assistant assistant = new Assistant(parkList);
        Parking emptyParking = assistant.getEmptyParking();
        assistant.helpPark(emptyParking, car);
        int space = emptyParking.getSpace();
        assertThat(assistant.helpLeave(emptyParking, car), is(true));
        assertThat(emptyParking.getSpace(), is(space + 1));
    }
}
