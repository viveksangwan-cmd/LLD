
import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingLot {
    public int id;
    public VehicalType vehicalType;
    public AtomicBoolean isOccuiped;
    public Vehicale vehicale;

    public ParkingLot(int id,VehicalType type){
        this.id = id;
        this.vehicalType = type;
        this.isOccuiped = new AtomicBoolean(false);
    }
}
