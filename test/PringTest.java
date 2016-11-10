import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 10/11/16.
 */
public class PringTest {
    private static final int CAPACITY = 1;

    @Test
    public void should_print_data_when_it_is_a_parklot() throws Exception {
        Parking parking = new Parking(CAPACITY);
        Report report = new Report("");
        assertThat(report.printParkinglot(parking.getSpace(), parking.getCapacity()), is("Parkinglot:1/1\n"));
    }

    @Test
    public void should_print_parklot_and_data_when_it_is_a_parker() throws Exception {
        withParkingCapability parking = new Parking(CAPACITY);
        ArrayList<withParkingCapability> parkList = new ArrayList<>();
        parkList.add(parking);
        Report report = new Report("");
        assertThat(report.printParker(parkList), is("Parker\n  Parkinglot:1/1\n"));
    }

    @Test
    public void should_print_parker_parkinglot_data_when_it_is_a_high_level_parker() throws Exception {
        withParkingCapability parking = new Parking(CAPACITY);
        ArrayList<withParkingCapability> parkList = new ArrayList<>();
        parkList.add(parking);
        withParkingCapability manager = new Manager(parkList);
        ArrayList<withParkingCapability> managers = new ArrayList<>();
        managers.add(manager);
        Report report = new Report("");
        assertThat(report.printParker(managers), is("Parker\n  Parker\n    Parkinglot:1/1\n"));
    }
}
