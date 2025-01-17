package models;

import enums.ParkingSpotType;

import java.util.*;

public class ParkingLotDynamic {

    private String name;
    private Map<ParkingSpotType, Queue<ParkingSpot>> parkingSpots;
    private static ParkingLotDynamic instance = null;

    private ParkingLotDynamic( String name) {
        this.name = name;
        this.parkingSpots = new HashMap<>();
    }

    public static ParkingLotDynamic getInstance(String name) {
        if (instance == null) {
            instance = new ParkingLotDynamic(name);
        }
        return instance;
    }

    //Initialize parking spots based on capacities
    public void initializeSpots(Map<ParkingSpotType, Integer> capacities){

        for(ParkingSpotType type : ParkingSpotType.values()){
            parkingSpots.put(type, new LinkedList<>());
            for(int i = 0; i < capacities.getOrDefault(type,0); i++){
                switch(type){
                    case COMPACT -> parkingSpots.get(type).add(new CompactParkingSpot(i+1));
                    case LARGE -> parkingSpots.get(type).add(new LargeParkingSpot(i+1));
                    case MOTORCYCLE -> parkingSpots.get(type).add(new MotorcycleParkingSpot(i+1));
                }
            }
        }
    }

    //Park a vehicle
    public ParkingSpot parkVehicle(Vehicle vehicle) {
        Queue<ParkingSpot> spots = parkingSpots.get(vehicle.getVehicleType());

        if(spots == null || spots.isEmpty()){
            System.out.println("Vehicle " + vehicle.getVehicleType() + " has no parking spots");
            return null;
        }
        ParkingSpot spot = spots.poll();
        spot.parkVehicle(vehicle);
        return spot;
    }

    //Free a parking spot
    public void freeParkingSpot(ParkingSpot spot) {
        spot.removeVehicle();
        parkingSpots.get(spot.getSpotType()).offer(spot);
    }

    public Collection<ParkingSpot> getParkingSpots(ParkingSpotType type) {
        return parkingSpots.get(type);
    }
}
