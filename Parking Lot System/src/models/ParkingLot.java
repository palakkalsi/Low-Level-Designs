package models;

import enums.ParkingSpotType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private String name;
    private Map<ParkingSpotType, List<ParkingSpot>> parkingSpots;
    private static ParkingLot instance = null;

    //Private Constructor for Singleton
    private ParkingLot(String name) {
        this.name = name;
        this.parkingSpots = new HashMap<>();
        for(ParkingSpotType type : ParkingSpotType.values()) {
            parkingSpots.put(type,new ArrayList<>());
        }
    }

    //Singleton instance getter
    public static ParkingLot getInstance(String name) {
        if(instance == null) {
            instance = new ParkingLot("Parking Lot");
        }
        return instance;
    }

    //Method to add a parking spot
    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.get(parkingSpot.getSpotType()).add(parkingSpot);
    }

    //Method to find and assign a spot for a vehicle
    public ParkingSpot parkVehicle(Vehicle vehicle){
        List<ParkingSpot> spots = parkingSpots.get(vehicle.getVehicleType());

        for(ParkingSpot spot : spots) {
            if(spot.isAvailable()){
               spot.parkVehicle(vehicle);
               return spot;
            }
        }

        System.out.println("No available spots for vehicle type " + vehicle.getVehicleType());
        return null;
    }

    //Method to free a parkingSpot

    public void freeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.removeVehicle();
    }

    public String getName() {
        return name;
    }

}
