package Week_8.Lab;
abstract class Vehicle {
    protected int speed;
    protected String fuelType;

    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }
    public abstract void startEngine();
}
interface Maintainable {
    void serviceInfo();
}
class Car extends Vehicle implements Maintainable {
    private String model;
    public Car(int speed, String fuelType, String model) {
        super(speed, fuelType);
        this.model = model;
    }
    @Override
    public void startEngine() {
        System.out.println("Starting engine of " + model + " car...");
    }
    @Override
    public void serviceInfo() {
        System.out.println("Service required every 10,000 km or 6 months.");
    }
    public void showDetails() {
        System.out.println("Car Model: " + model);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}
public class TransportDemo {
    public static void main(String[] args) {
        Car myCar = new Car(180, "Petrol", "Honda City");
        myCar.startEngine();
        myCar.serviceInfo();
        myCar.showDetails();
    }
}