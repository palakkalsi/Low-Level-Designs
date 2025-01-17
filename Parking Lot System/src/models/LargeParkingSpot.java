package models;

import enums.ParkingSpotType;

public class LargeParkingSpot extends ParkingSpot {
    public LargeParkingSpot(int spotNumber) {
        super(spotNumber, ParkingSpotType.LARGE);
    }
}
