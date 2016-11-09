import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 09/11/16.
 */
public class ParkingTest {

    public static final boolean IS_EMPTY = true;
    public static final boolean ISNOT_EMPTY = false;

    @Test
    public void car_can_come_in_when_parking_is_empty() throws Exception {
        assertThat(new Parking(IS_EMPTY).canComeIn(), is(true));
    }

    @Test
    public void car_cannot_come_in_when_parking_isnot_empty() throws Exception {
        assertThat(new Parking(ISNOT_EMPTY).canComeIn(), is(false));
    }

    @Test
    public void car_can_come_out_when_parking_isnot_empty() throws Exception {
        assertThat(new Parking(ISNOT_EMPTY).canComeOut(), is(true));
    }
}
