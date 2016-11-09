import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 09/11/16.
 */
public class AssistantTest {

    public static final int CAPACITY = 2;

    @Test
    public void car_cannot_come_in_when_three_parking_are_full() throws Exception {
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(new Parking(CAPACITY));
        parkList.add(new Parking(CAPACITY));
        parkList.add(new Parking(CAPACITY));
        Assistant assistant = new Assistant(parkList);
        assertThat(assistant.canComeIn(), is(false));
    }

    @Test
    public void car_can_come_in_parking3_when_parking3_is_empty() throws Exception {
        Parking parking3 = new Parking(CAPACITY);
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(new Parking(CAPACITY));
        parkList.add(new Parking(CAPACITY));
        parkList.add(parking3);
        Assistant assistant = new Assistant(parkList);
        assertThat(assistant.canComeIn(), is(true));
        assertThat(assistant.getEmptyParking(), is(parking3));
    }

    @Test
    public void assistant_can_help_park_car_when_parking_is_empty() throws Exception {
        Parking parking3 = new Parking(CAPACITY);
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(new Parking(CAPACITY));
        parkList.add(new Parking(CAPACITY));
        parkList.add(parking3);
        Assistant assistant = new Assistant(parkList);
        Parking emptyParking = assistant.getEmptyParking();
        int space = emptyParking.getSpace();
        assistant.helpPark(emptyParking, new Car(0));
        assertThat(emptyParking.getSpace(), is(space - 1));
    }

    @Test
    public void assistant_can_help_leave_car_when_car_is_in_parking() throws Exception {
        Parking parking3 = new Parking(CAPACITY);
        ArrayList<Parking> parkList = new ArrayList<>();
        parkList.add(new Parking(CAPACITY));
        parkList.add(new Parking(CAPACITY));
        parkList.add(parking3);
        Assistant assistant = new Assistant(parkList);
        Parking emptyParking = assistant.getEmptyParking();
        assistant.helpPark(emptyParking, new Car(0));
        int space = emptyParking.getSpace();
        assistant.helpLeave(emptyParking, new Car(0));
        assertThat(emptyParking.getSpace(), is(space + 1));
    }
}
