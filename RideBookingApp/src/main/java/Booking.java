public class Booking {
    public int id;
    public Driver driver;
    public User user;
    public Location staringLoc;
    public Location endLoc;
//    public amount;
//    public int timeTaken;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getStaringLoc() {
        return staringLoc;
    }

    public void setStaringLoc(Location staringLoc) {
        this.staringLoc = staringLoc;
    }

    public Location getEndLoc() {
        return endLoc;
    }

    public void setEndLoc(Location endLoc) {
        this.endLoc = endLoc;
    }
}
