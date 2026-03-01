package Week_3.Practice;
import java.time.Year;
public class Car {
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false; 
    }
    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }
    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.\n");
    }
    public void displayInfo() {
        System.out.println("Car Info:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Is Running: " + isRunning);
        System.out.println("Age: " + getAge() + " years");
        System.out.println();
    }
    public int getAge() {
        int currentYear = Year.now().getValue();
        return currentYear - year;
    }
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2018, "Red");
        Car car2 = new Car("Honda", "Civic", 2020, "Blue");
        Car car3 = new Car("Ford", "Mustang", 2015, "Black");
        car1.startEngine();
        car1.displayInfo();
        car2.displayInfo(); 
        car2.startEngine();
        car2.stopEngine();
        car3.startEngine();
        car3.displayInfo();
        // Each car maintains its own state independently
        // car1 is running, car2 is stopped, car3 is running
        // Real-world analogy:
        // Just like actual cars, each Car object has its own brand, model, color, and engine state.
        // You can start or stop each car independently, and their age depends on their manufacturing year.
    }
}
