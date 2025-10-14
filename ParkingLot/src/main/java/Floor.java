import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Floor {
    public final int id;
    public final int noOfSlots;
    public final List<ParkingLot> parkingLotList;

    public Floor(int id,int noOfSlots){
        this.id = id;
        this.noOfSlots = noOfSlots;
        parkingLotList = new ArrayList<>(noOfSlots);
        for(int i=0;i<noOfSlots;i++){
//            For now making it default to BIKE, otherwise we can ask users who many will lots will be allocated to different types using a config pojo class
            parkingLotList.add(new ParkingLot(i,VehicalType.BIKE));
        }
    }

    public Optional<ParkingLot> getAvailableLot(VehicalType vehicalType){
        System.out.println("Checking for available parking lot at floor "+id+" with vehicle type "+vehicalType.name()+" .......");
        return parkingLotList.stream().filter(parkingLot -> parkingLot.isOccuiped.compareAndSet(false,true)).findFirst();
    }
}
