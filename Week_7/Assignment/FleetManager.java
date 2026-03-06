package Week_7.Assignment;
class Vehicle {
    void dispatch() {
        System.out.println("Dispatching generic vehicle...");
    }
}
class Bus extends Vehicle {
    void dispatch() {
        System.out.println("Bus dispatched on fixed route. Passenger capacity tracked.");
    }
}
class Taxi extends Vehicle {
    void dispatch() {
        System.out.println("Taxi dispatched for door-to-door service. Fare calculated by distance.");
    }
}
class Train extends Vehicle {
    void dispatch() {
        System.out.println("Train dispatched on schedule. Managing multiple car capacity.");
    }
}
class Bike extends Vehicle {
    void dispatch() {
        System.out.println("Bike dispatched for short-distance eco-friendly trip.");
    }
}
public class FleetManager {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Bus(),
            new Taxi(),
            new Train(),
            new Bike(),
            new Taxi()
        };
        for (Vehicle v : fleet)
            v.dispatch();
    }
}