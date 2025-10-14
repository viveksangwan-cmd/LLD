public class Main {
    static void main() throws Exception {

//        Singleton
        ParkingService parkingService = ParkingService.getInstance();

        Floor floor = new Floor(1,5);
        parkingService.addFloor(floor);

//        We can have factory
        Vehicale vehicle = new Vehicale(1,"HR19",VehicalType.BIKE);


        Ticket ticket = parkingService.parkVehicle(1,vehicle);

//        We can have factory
        PaymentService paymentService = new UPIPaymentService();
        parkingService.leaveVehicle(ticket,paymentService);
    }
}
