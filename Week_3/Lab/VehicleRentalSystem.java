package Week_3.Lab;
class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private int timesRented;
    private static int totalVehicles = 0;
    private static double totalRevenue = 0.0;
    private static String companyName = "Default Rentals";
    private static int rentalDays = 0;
    private static int vehicleCounter = 0;
    public Vehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.timesRented = 0;
        totalVehicles++;
    }
    private static String generateVehicleId() {
        vehicleCounter++;
        return "VEH" + String.format("%03d", vehicleCounter);
    }
    public void rentVehicle(int days) {
        if (isAvailable) {
            double rent = calculateRent(days);
            isAvailable = false;
            timesRented++;
            System.out.println(vehicleId + " rented for " + days + " days. Rent: ₹" + rent);
        } else {
            System.out.println(vehicleId + " is currently unavailable.");
        }
    }
    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(vehicleId + " has been returned and is now available.");
        } else {
            System.out.println(vehicleId + " was not rented.");
        }
    }
    public double calculateRent(int days) {
        double rent = rentPerDay * days;
        totalRevenue += rent;
        rentalDays += days;
        return rent;
    }
    public void displayVehicleInfo() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rent/Day: ₹" + rentPerDay);
        System.out.println("Available: " + isAvailable);
        System.out.println("Times Rented: " + timesRented);
        System.out.println();
    }
    public static void setCompanyName(String name) {
        companyName = name;
    }
    public static double getTotalRevenue() {
        return totalRevenue;
    }
    public static double getAverageRentPerDay() {
        return rentalDays == 0 ? 0 : totalRevenue / rentalDays;
    }
    public static void displayCompanyStats() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.println("Total Revenue: ₹" + totalRevenue);
        System.out.println("Total Rental Days: " + rentalDays);
        System.out.println("Average Rent/Day: ₹" + String.format("%.2f", getAverageRentPerDay()));
        System.out.println();
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle.setCompanyName("ZoomGo Rentals");
        Vehicle v1 = new Vehicle("Toyota", "Innova", 1500);
        Vehicle v2 = new Vehicle("Honda", "City", 1200);
        Vehicle v3 = new Vehicle("Suzuki", "Swift", 1000);
        v1.rentVehicle(3); // ₹4500
        v2.rentVehicle(2); // ₹2400
        v3.rentVehicle(5); // ₹5000
        v1.returnVehicle();
        v2.returnVehicle();
        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();
        Vehicle.displayCompanyStats();
    }
}