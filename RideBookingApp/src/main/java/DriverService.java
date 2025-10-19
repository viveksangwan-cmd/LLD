import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DriverService {
    private List<Driver> drivers;
    private HashMap<Integer,List<Booking>> driverHistory;
    private static DriverService instance;

    private DriverService(){
        this.driverHistory = new HashMap<>();
        this.drivers = new ArrayList<>();
    }

    public static DriverService getInstance(){
        if(instance==null){
            synchronized (DriverService.class){
                if(instance==null) {
                    instance = new DriverService();
                }
            }
        }
        return instance;
    }

    public HashMap<Integer, List<Booking>> getDriverHistory() {
        return driverHistory;
    }

    public void addDriver(Driver driver){
        drivers.add(driver);
    }

    public List<Driver> getDriversForLocation(Location location, FindDriver findDriver){
        return findDriver.getDriver(location,drivers);
    }
}
