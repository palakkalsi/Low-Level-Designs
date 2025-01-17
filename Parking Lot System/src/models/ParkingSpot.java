package models;

import enums.ParkingSpotType;

public abstract class ParkingSpot {
    private int spotNumber;
    private ParkingSpotType spotType;
    private boolean isAvailable;
    private Vehicle vehicle;

    ParkingSpot(int spotNumber, ParkingSpotType spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }



    public void parkVehicle(Vehicle vehicle) {
          this.vehicle = vehicle;
          isAvailable = false;
    }

    public void removeVehicle() {
          this.vehicle = null;
          isAvailable = true;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
