import enums.ParkingSpotType;
import models.*;

import java.util.*;


public class MainDynamic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Step 1: Initialize the parking lot
        System.out.print("Enter the name of the parking lot: ");
        String name = scanner.nextLine();
        ParkingLotDynamic parkingLot = ParkingLotDynamic.getInstance(name);

        //Step 2: Define capacities for different spot types
        Map<ParkingSpotType,Integer> capacities = new HashMap<>();
        for(ParkingSpotType type : ParkingSpotType.values()) {
            System.out.println("Enter the capacity for " + type + ": ");
            int capacity = scanner.nextInt();
            capacities.put(type, capacity);
        }

        parkingLot.initializeSpots(capacities);

        //Step 3: Interactive menu
        while (true) {
            System.out.println("\n--- Parking Lot Menu ---");
            System.out.println("1. Park a vehicle");
            System.out.println("2. Remove a vehicle");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter vehicle type (CAR/TRUCK/VAN/MOTORCYCLE): ");
                    String vehicleTypeInput = scanner.nextLine().toUpperCase();
                    System.out.print("Enter vehicle license plate: ");
                    String licensePlate = scanner.nextLine();

                    Vehicle vehicle = switch (vehicleTypeInput) {
                        case "CAR" -> new Car(licensePlate);
                        case "TRUCK" -> new Truck(licensePlate);
                        case "MOTORCYCLE" -> new MotorCycle(licensePlate);
                        default -> null;
                    };

                    if (vehicle != null) {
                        ParkingSpot spot = parkingLot.parkVehicle(vehicle);
                        if (spot != null) {
                            System.out.println("Vehicle parked in spot #" + spot.getSpotNumber());
                        }
                    } else {
                        System.out.println("Invalid vehicle type!");
                    }
                }
                case 2 -> {
                    System.out.print("Enter spot number to free: ");
                    int spotNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    // Assume spot numbers are unique across all types
                    boolean found = false;
                    for (ParkingSpotType type : ParkingSpotType.values()) {
                        for (ParkingSpot spot : parkingLot.getParkingSpots(type)) {
                            if (spot.getSpotNumber() == spotNumber && !spot.isAvailable()) {
                                parkingLot.freeParkingSpot(spot);
                                System.out.println("Spot #" + spotNumber + " is now free.");
                                found = true;
                                break;
                            }
                        }
                        if (found) break;
                    }
                    if (!found) {
                        System.out.println("Spot not found or already free.");
                    }
                }
                case 3 -> {
                    System.out.println("Exiting the parking lot system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }

}
