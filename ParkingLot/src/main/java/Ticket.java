import java.time.Instant;

public class Ticket {
    public int ticketId;
    public String vehicleNumber;
    public Instant inTime;

    public Ticket(int ticketId,String vehicleNumber,Instant timestamp){
        this.inTime = timestamp;
        this.vehicleNumber = vehicleNumber;
        this.ticketId = ticketId;
        System.out.println("Ticket is generate with the following details : ");
        System.out.println("Vehicle id : "+vehicleNumber);
        System.out.println("TimeStamp : "+inTime);
    }
}
