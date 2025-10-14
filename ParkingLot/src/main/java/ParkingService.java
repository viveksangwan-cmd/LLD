import lombok.Getter;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class ParkingService {
    private final ConcurrentHashMap<Integer,Floor> floors;
    private static ParkingService instance;

    private ParkingService(){
        floors = new ConcurrentHashMap<>();
    }

    public static ParkingService getInstance(){
        if(instance==null){
            synchronized (ParkingService.class){
                if(instance==null){
                    instance = new ParkingService();
                }
            }
        }
        return instance;
    }

    public void addFloor(Floor floor){
        floors.put(floor.id,floor);
    }

    public Ticket parkVehicle(int floorId,Vehicale vehicale) throws Exception {
        Floor floor = floors.getOrDefault(floorId,null);
        Optional<ParkingLot> parkingLot = floor.getAvailableLot(vehicale.type);
        if(parkingLot.isEmpty()) throw new Exception("No parking lot with vehicale available.");
        System.out.println("Found available parking lot with id "+parkingLot.get().id);
        parkingLot.get().isOccuiped.set(true);
        parkingLot.get().vehicale = vehicale;
        return new Ticket(vehicale.id, vehicale.vehicaleNumber, Instant.now());
    }


    public boolean leaveVehicle(Ticket ticket,PaymentService paymentServiec){
        double vehicleAmountCalculatedAsMin = Duration.between(ticket.inTime, Instant.now()).toMinutes();
        System.out.println("Trying payment of "+vehicleAmountCalculatedAsMin+" with "+paymentServiec.getClass());
        return paymentServiec.getPayment(vehicleAmountCalculatedAsMin);
    }
}
