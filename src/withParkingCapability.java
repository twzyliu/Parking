/**
 * Created by zyongliu on 10/11/16.
 */
public interface withParkingCapability {
    int getCapacity();

    boolean park(Car myCar);

    boolean unpark(Car myCar);

    int getSpace();

    double getSpacePercentage();

    boolean isAvailable();

    withParkingCapability getAvailableParking();

    String play(String space);

}
