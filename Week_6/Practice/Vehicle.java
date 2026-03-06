package Week_6.Practice;
import java.util.Random;
public class Vehicle {
    protected String model;
    private String brand;
    protected int year;
    protected String engineType;
    private String registrationNumber;
    private boolean isRunning;
    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.engineType = "Unknown";
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }
    private String generateRegistrationNumber() {
        return "REG" + new Random().nextInt(10000);
    }
    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }
    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }
    public String getVehicleInfo() {
        return String.format("Brand: %s, Model: %s, Year: %d, Engine: %s, Reg#: %s, Running: %b",
                brand, model, year, engineType, registrationNumber, isRunning);
    }
    public void displaySpecs() {
        System.out.println("Vehicle Specs:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public boolean isRunning() {
        return isRunning;
    }
}
class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;
    public Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }
    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }
    @Override
    public void start() {
        super.start();
        System.out.println("Car-specific startup sequence initiated");
    }
    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Car Specs:");
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission: " + transmissionType);
    }
    public void openTrunk() {
        System.out.println("Trunk opened");
    }
    public void playRadio() {
        System.out.println("Radio playing music");
    }
    public static void main(String[] args) {
        Car defaultCar = new Car();
        System.out.println(defaultCar.getVehicleInfo());
        defaultCar.displaySpecs();
        defaultCar.start();
        defaultCar.openTrunk();
        defaultCar.playRadio();
        defaultCar.stop();
        System.out.println();
        Car paramCar = new Car("Toyota", "Camry", 2022, "Hybrid", 4, "Petrol", "Automatic");
        System.out.println(paramCar.getVehicleInfo());
        paramCar.displaySpecs();
        paramCar.start();
        paramCar.openTrunk();
        paramCar.playRadio();
        paramCar.stop();
    }
}