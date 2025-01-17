package models;

import enums.ParkingSpotType;

public class CompactParkingSpot extends ParkingSpot {

    public CompactParkingSpot(int spotNumber) {
        super(spotNumber, ParkingSpotType.COMPACT);
    }
}
