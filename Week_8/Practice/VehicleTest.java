package Week_8.Practice;
abstract class Vehicle {
    public abstract void start();
    public void fuelType() {
        System.out.println("Uses petrol");
    }
}

class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car starts with key");
    }
}
 class Bike extends Vehicle {
    @Override
    public void start() {
        System.out.println("Bike starts with kick");
    }
}
public class VehicleTest {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start(); 
        myCar.fuelType();
        Vehicle myBike = new Bike();
        myBike.start();
        myBike.fuelType();
    }
}