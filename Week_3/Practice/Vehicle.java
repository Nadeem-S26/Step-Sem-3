package Week_3.Practice;
public class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }
    public void startVehicle() {
        System.out.println(make + " " + model + " started.");
    }
    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }
    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled. Current fuel level: " + fuelLevel + " liters.");
    }
    public void displayVehicleInfo() {
        System.out.println("Vehicle Info:");
        System.out.println("Make       : " + make);
        System.out.println("Model      : " + model);
        System.out.println("Year       : " + year);
        System.out.println("Fuel Level : " + fuelLevel + " liters");
        System.out.println();
    }
    public static void main(String[] args) {
        class Car extends Vehicle {
            public Car(String make, String model, int year, double fuelLevel) {
                super(make, model, year, fuelLevel);
            }
        }
        class Truck extends Vehicle {
            public Truck(String make, String model, int year, double fuelLevel) {
                super(make, model, year, fuelLevel);
            }
        }
        class Motorcycle extends Vehicle {
            public Motorcycle(String make, String model, int year, double fuelLevel) {
                super(make, model, year, fuelLevel);
            }
        }
        Vehicle v1 = new Car("Toyota", "Camry", 2020, 40.0);
        Vehicle v2 = new Truck("Ford", "F-150", 2018, 60.0);
        Vehicle v3 = new Motorcycle("Yamaha", "R15", 2022, 15.0);
        Vehicle[] fleet = { v1, v2, v3 };
        for (Vehicle v : fleet) {
            v.startVehicle();
            v.refuel(10);
            v.displayVehicleInfo();
            v.stopVehicle();
        }

        /*
         * How does this show reusability?
         * - The Vehicle class defines shared attributes and behaviors.
         * - Car, Truck, and Motorcycle reuse this logic without rewriting it.
         *
         * How could this be extended for new vehicle types?
         * - You can create new subclasses like ElectricCar or Bus by extending Vehicle.
         * - Override or add methods specific to those types.
         *
         * What are the benefits over writing separate classes?
         * - Avoids code duplication.
         * - Easier to maintain and update shared logic.
         * - Enables polymorphism: treat all vehicles uniformly while preserving their specific types.
         */
    }
}

