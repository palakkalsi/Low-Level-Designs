package models;

import enums.ParkingSpotType;

public class MotorcycleParkingSpot extends ParkingSpot {
   public MotorcycleParkingSpot(int spotNumber){
       super(spotNumber, ParkingSpotType.MOTORCYCLE);
   }
}
