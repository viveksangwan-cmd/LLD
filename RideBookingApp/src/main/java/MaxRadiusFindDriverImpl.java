import java.util.List;
import java.util.stream.Collectors;

public class MaxRadiusFindDriverImpl implements FindDriver{
    @Override
    public List<Driver> getDriver(Location location, List<Driver> driverList) {
        return driverList.stream().filter(driver -> isValidDriver(location,driver)).collect(Collectors.toList());
    }

    private boolean isValidDriver(Location userLocation,Driver driver){
        return true;
    }
}
