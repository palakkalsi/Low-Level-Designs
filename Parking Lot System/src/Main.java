import models.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("WELCOME :)");


        //Step 1 : CREATE A PARKING LOT
        ParkingLot parkingLot = ParkingLot.getInstance("MyParkingLot");

        //Step 2 : ADD PARKING SPOTS

        ParkingSpot compactSpot1 = new CompactParkingSpot(1);
        ParkingSpot compactSpot2 = new CompactParkingSpot(2);
        ParkingSpot compactSpot3 = new CompactParkingSpot(3);

        ParkingSpot motorcycleSpot1 = new MotorcycleParkingSpot(4);
        ParkingSpot motorcycleSpot2 = new MotorcycleParkingSpot(5);
        ParkingSpot motorcycleSpot3 = new MotorcycleParkingSpot(6);

        ParkingSpot largeSpot1 = new LargeParkingSpot(7);
        ParkingSpot largeSpot2 = new LargeParkingSpot(8);
        ParkingSpot largeSpot3 = new LargeParkingSpot(9);

        parkingLot.addParkingSpot(compactSpot1);
        parkingLot.addParkingSpot(compactSpot2);
        parkingLot.addParkingSpot(compactSpot3);
        parkingLot.addParkingSpot(motorcycleSpot1);
        parkingLot.addParkingSpot(motorcycleSpot2);
        parkingLot.addParkingSpot(motorcycleSpot3);
        parkingLot.addParkingSpot(largeSpot1);
        parkingLot.addParkingSpot(largeSpot2);
        parkingLot.addParkingSpot(largeSpot3);

        //PARK VEHICLES

        Vehicle car1 = new Car("PB123");
        Vehicle car2 = new Car("PB456");
        Vehicle truck1 = new Truck("T-PB123");
        Vehicle motorcycle1 = new MotorCycle("M-PB123");

        System.out.println("Parking in ~ " + parkingLot.getName());

        ParkingSpot spot1 = parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(truck1);
        parkingLot.parkVehicle(motorcycle1);

        //FREE A SPOT
        if(spot1 != null){
            System.out.println("Freeing spot1 fot car1");
            parkingLot.freeParkingSpot(spot1);
        }

        //PARK ANOTHER VEHICLE AFTER FREEING A SPOT
        Vehicle car3 = new Car("PB789");
        ParkingSpot spot3 = parkingLot.parkVehicle(car3);

    }
}