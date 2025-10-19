import java.util.List;

public class RideBookingApplication {
    static void main() {
        User user = new User();
        user.setLocation(new Location(1,5));

        Driver driver = new Driver();
        driver.setLocation(new Location(1,88));

        FindDriver findDriver = new MaxRadiusFindDriverImpl();

        DriverService driverService = DriverService.getInstance();
        driverService.addDriver(driver);
        List<Driver> drivers = driverService.getDriversForLocation(user.getLocation(),findDriver);
        drivers.stream().forEach(driver1 -> System.out.println("Driver available at loc : "+driver1.getLocation().posX+" "+driver1.getLocation().getPosY()));


    }
}
