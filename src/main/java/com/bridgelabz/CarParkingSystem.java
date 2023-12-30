class CarParkingSystem {
    public static void main(String[] args) {
        // Create parking lots
        ParkingLot lot1 = new ParkingLot(5);
        ParkingLot lot2 = new ParkingLot(5);

        // Create a list of parking lots
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(lot1);
        parkingLots.add(lot2);

        // Create a parking attendant with the list of parking lots
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLots);

        // Simulate parking cars
        parkingAttendant.directCar(); // Car 1 parked
        parkingAttendant.directCar(); // Car 2 parked
        parkingAttendant.directCar(); // Car 3 parked
        parkingAttendant.directCar(); // Car 4 parked
        parkingAttendant.directCar(); // Car 5 parked
        parkingAttendant.directCar(); // Parking lot is full

        // Display parking lot status
        System.out.println("Parking Lot 1: " + (lot1.hasAvailableSpot() ? "Available spots" : "Full"));
        System.out.println("Parking Lot 2: " + (lot2.hasAvailableSpot() ? "Available spots" : "Full"));
    }
}
