package Week_3.Assignment;
abstract class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected int year;
    protected double mileage;
    protected String fuelType;
    protected String currentStatus;
    protected double purchaseValue;
    protected double fuelEfficiencyKmPerL;
    protected double maintenanceCostPerKm;
    protected double serviceIntervalKm;
    protected double lastServiceMileage;
    protected double cumulativeMaintenanceSpent;
    protected Driver assignedDriver;
    protected static int totalVehicles = 0;
    protected static double fleetValue = 0.0;
    protected static String companyName = "FleetWorks Logistics";
    protected static double totalFuelConsumption = 0.0;
    public Vehicle(String vehicleId, String brand, String model, int year, double mileage,
                   String fuelType, String currentStatus, double purchaseValue,
                   double fuelEfficiencyKmPerL, double maintenanceCostPerKm, double serviceIntervalKm) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.currentStatus = currentStatus;
        this.purchaseValue = purchaseValue;
        this.fuelEfficiencyKmPerL = fuelEfficiencyKmPerL;
        this.maintenanceCostPerKm = maintenanceCostPerKm;
        this.serviceIntervalKm = serviceIntervalKm;
        this.lastServiceMileage = mileage;
        totalVehicles++;
        fleetValue += purchaseValue;
    }
    public abstract String getType();
    public void assignDriver(Driver driver) {
        if (driver != null) {
            this.assignedDriver = driver;
            driver.assignedVehicle = this;
        }
    }

    public void scheduleMaintenance(double serviceJobCost) {
        double kmSinceLast = mileage - lastServiceMileage;
        double variableCost = kmSinceLast * maintenanceCostPerKm;
        cumulativeMaintenanceSpent += variableCost + serviceJobCost;
        lastServiceMileage = mileage;
        currentStatus = "Available";
    }

    public double calculateRunningCost(double distanceKm, double fuelPricePerL) {
        double fuelLiters = distanceKm / fuelEfficiencyKmPerL;
        double fuelCost = fuelLiters * fuelPricePerL;
        double maintenanceVar = distanceKm * maintenanceCostPerKm;
        return fuelCost + maintenanceVar;
    }

    public void updateMileage(double tripDistanceKm) {
        mileage += tripDistanceKm;
        double consumed = tripDistanceKm / fuelEfficiencyKmPerL;
        totalFuelConsumption += consumed;
    }

    public boolean checkServiceDue() {
        return (mileage - lastServiceMileage) >= serviceIntervalKm;
    }

    public String getVehicleId() { return vehicleId; }
    public String getCurrentStatus() { return currentStatus; }
    public double getCumulativeMaintenanceSpent() { return cumulativeMaintenanceSpent; }
    public static int getTotalVehicles() { return totalVehicles; }
    public static double getFleetValue() { return fleetValue; }
    public static String getCompanyName() { return companyName; }
    public static void setCompanyName(String name) { companyName = name; }
    public static double getTotalFuelConsumption() { return totalFuelConsumption; }

    public void setStatus(String status) { this.currentStatus = status; }

    public void display() {
        System.out.println("[" + getType() + "] " + brand + " " + model + " (" + year + ") | ID: " + vehicleId + " | Fuel: " + fuelType + " | Status: " + currentStatus + " | Mileage: " + mileage + " km");
    }
}

class Car extends Vehicle {
    private int seatingCapacity;
    private boolean hasAC;
    public Car(String vehicleId, String brand, String model, int year, double mileage, String fuelType,
               double purchaseValue, double fuelEfficiencyKmPerL, double maintenanceCostPerKm, double serviceIntervalKm,
               int seatingCapacity, boolean hasAC) {
        super(vehicleId, brand, model, year, mileage, fuelType, "Available", purchaseValue,
                fuelEfficiencyKmPerL, maintenanceCostPerKm, serviceIntervalKm);
        this.seatingCapacity = seatingCapacity;
        this.hasAC = hasAC;
    }
    public String getType() { return "Car"; }
}

class Bus extends Vehicle {
    private int seatingCapacity;
    public Bus(String vehicleId, String brand, String model, int year, double mileage, String fuelType,
               double purchaseValue, double fuelEfficiencyKmPerL, double maintenanceCostPerKm, double serviceIntervalKm,
               int seatingCapacity) {
        super(vehicleId, brand, model, year, mileage, fuelType, "Available", purchaseValue,
                fuelEfficiencyKmPerL, maintenanceCostPerKm, serviceIntervalKm);
        this.seatingCapacity = seatingCapacity;
    }
    public String getType() { return "Bus"; }
}

class Truck extends Vehicle {
    private double loadCapacityTons;
    public Truck(String vehicleId, String brand, String model, int year, double mileage, String fuelType,
                 double purchaseValue, double fuelEfficiencyKmPerL, double maintenanceCostPerKm, double serviceIntervalKm,
                 double loadCapacityTons) {
        super(vehicleId, brand, model, year, mileage, fuelType, "Available", purchaseValue,
                fuelEfficiencyKmPerL, maintenanceCostPerKm, serviceIntervalKm);
        this.loadCapacityTons = loadCapacityTons;
    }
    public String getType() { return "Truck"; }
}

class Driver {
    String driverId;
    String driverName;
    String licenseType;
    Vehicle assignedVehicle;
    int totalTrips;
    public Driver(String driverId, String driverName, String licenseType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.licenseType = licenseType;
    }
    public void display() {
        System.out.println("Driver " + driverId + " | " + driverName + " | License: " + licenseType + " | Vehicle: " + (assignedVehicle == null ? "None" : assignedVehicle.getVehicleId()) + " | Trips: " + totalTrips);
    }
}

class Trip {
    String tripId;
    Vehicle vehicle;
    Driver driver;
    String origin;
    String destination;
    double distanceKm;
    double fuelPricePerL;
    double runningCost;
    boolean completed;
    public Trip(String tripId, Vehicle vehicle, Driver driver,
                String origin, String destination, double distanceKm, double fuelPricePerL) {
        this.tripId = tripId;
        this.vehicle = vehicle;
        this.driver = driver;
        this.origin = origin;
        this.destination = destination;
        this.distanceKm = distanceKm;
        this.fuelPricePerL = fuelPricePerL;
    }
    public void start() {
        if (!"Available".equalsIgnoreCase(vehicle.getCurrentStatus())) return;
        vehicle.setStatus("On Trip");
    }
    public void complete() {
        runningCost = vehicle.calculateRunningCost(distanceKm, fuelPricePerL);
        vehicle.updateMileage(distanceKm);
        vehicle.setStatus("Available");
        if (driver != null) driver.totalTrips++;
        completed = true;
    }
    public void display() {
        System.out.println("Trip " + tripId + " | " + origin + " -> " + destination + " | " + distanceKm + " km | Vehicle: " + vehicle.getVehicleId() + " | Driver: " + (driver == null ? "N/A" : driver.driverName) + " | Cost: Rs. " + runningCost + " | " + (completed ? "Completed" : "In-Progress"));
    }
}

class FleetReports {
    public static double getFleetUtilization(Vehicle[] vehicles) {
        int inUse = 0;
        for (Vehicle v : vehicles) {
            if (v != null && !"Available".equalsIgnoreCase(v.getCurrentStatus())) inUse++;
        }
        return (inUse * 100.0) / vehicles.length;
    }
    public static double calculateTotalMaintenanceCost(Vehicle[] vehicles) {
        double sum = 0.0;
        for (Vehicle v : vehicles) if (v != null) sum += v.getCumulativeMaintenanceSpent();
        return sum;
    }
    public static Vehicle[] getVehiclesByType(Vehicle[] vehicles, String type) {
        Vehicle[] result = new Vehicle[vehicles.length];
        int idx = 0;
        for (Vehicle v : vehicles) {
            if (v != null && v.getType().equalsIgnoreCase(type)) result[idx++] = v;
        }
        return result;
    }
}
@SuppressWarnings("all")
public class VehicleFleetManagement {
    public static void main(String[] args) {
        Vehicle.setCompanyName("Azure Transit Pvt Ltd");
        Vehicle[] fleet = new Vehicle[6];
        fleet[0] = new Car("C-101", "Toyota", "Etios", 2019, 62000, "Petrol", 650000, 16.0, 1.5, 10000, 5, true);
        fleet[1] = new Car("C-102", "Maruti", "Dzire", 2021, 41000, "Petrol", 750000, 18.0, 1.4, 12000, 5, true);
        fleet[2] = new Bus("B-201", "Tata", "Starbus", 2018, 180000, "Diesel", 3500000, 4.5, 3.5, 15000, 40);
        fleet[3] = new Bus("B-202", "Ashok Leyland", "Viking", 2020, 140000, "Diesel", 4200000, 4.0, 3.8, 15000, 45);
        fleet[4] = new Truck("T-301", "BharatBenz", "1214", 2017, 220000, "Diesel", 2800000, 5.0, 4.0, 12000, 12.0);
        fleet[5] = new Truck("T-302", "Tata", "LPT 1618", 2019, 165000, "Diesel", 3200000, 4.2, 4.2, 12000, 16.0);
        Driver[] drivers = new Driver[3];
        drivers[0] = new Driver("D001", "Nadeem", "LMV/HMV");
        drivers[1] = new Driver("D002", "Aisha", "PSV");
        drivers[2] = new Driver("D003", "Rahul", "HMV");
        fleet[0].assignDriver(drivers[0]);
        fleet[2].assignDriver(drivers[1]);
        fleet[4].assignDriver(drivers[2]);
        System.out.println("\n--- Fleet (" + Vehicle.getCompanyName() + ") ---");
        for (Vehicle v : fleet) v.display();
        System.out.println("\n-- Maintenance --");
        fleet[2].scheduleMaintenance(12000);
        Trip[] trips = new Trip[3];
        trips[0] = new Trip("TRIP-001", fleet[0], drivers[0], "Aminjikkarai", "Sholinganallur", 22.5, 105.0);
        trips[1] = new Trip("TRIP-002", fleet[2], drivers[1], "Central", "Airport", 18.0, 98.0);
        trips[2] = new Trip("TRIP-003", fleet[4], drivers[2], "Warehouse A", "Port", 56.0, 98.0);
        for (Trip t : trips) {
            t.start();
            t.complete();
            t.display();
        }
        System.out.println("\n-- Service Checks --");
        for (Vehicle v : fleet) {
            if (v.checkServiceDue()) {
                System.out.println("Service due: " + v.getVehicleId());
            }
        }
        System.out.println("\n--- Reports ---");
        System.out.println("Total Vehicles: " + Vehicle.getTotalVehicles());
        System.out.println("Fleet Value: Rs. " + Vehicle.getFleetValue());
        System.out.println("Total Fuel Consumed: " + Vehicle.getTotalFuelConsumption() + " L");
        System.out.println("Fleet Utilization: " + FleetReports.getFleetUtilization(fleet) + "%");
        System.out.println("Total Maintenance Spent: Rs. " + FleetReports.calculateTotalMaintenanceCost(fleet));
        Vehicle[] trucks = FleetReports.getVehiclesByType(fleet, "Truck");
        int truckCount = 0;
        for (Vehicle t : trucks) if (t != null) truckCount++;
        System.out.println("Trucks in fleet: " + truckCount);
        System.out.println("\n--- Drivers ---");
        for (Driver d : drivers) d.display();
        System.out.println("\n-- Cost Planning --");
        Vehicle planVehicle = fleet[1];
        double estimate = planVehicle.calculateRunningCost(75.0, 105.0);
        System.out.println("Planned 75 km trip with " + planVehicle.getVehicleId() + ": Estimated cost Rs. " + estimate);
    }
}