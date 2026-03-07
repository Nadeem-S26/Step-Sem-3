package Week_8.Assignment;
abstract class Vehicle {
    public abstract void start();
    public void stop() {
        System.out.println("Vehicle stopped.");
    }
}
interface Fuel {
    void refuel();
}
class Car extends Vehicle implements Fuel {
    private String model;
    public Car(String model) {
        this.model = model;
    }
    @Override
    public void start() {
        System.out.println(model + " engine started.");
    }
    @Override
    public void refuel() {
        System.out.println(model + " is refueling with petrol.");
    }
    public void showDetails() {
        System.out.println("Car Model: " + model);
    }
}
public class VehicleDemo {
    public static void main(String[] args) {
        Car myCar = new Car("Hyundai Verna");
        myCar.showDetails();
        myCar.start();
        myCar.refuel();
        myCar.stop();
    }
}