import lombok.Getter;
import lombok.Setter;

public class Vehicale {
    public final int id;
    public final String vehicaleNumber;
    public final VehicalType type;

    public Vehicale(int id,String vehicaleNumber,VehicalType type){
        this.id = id;
        this.vehicaleNumber = vehicaleNumber;
        this.type = type;
    }
}
