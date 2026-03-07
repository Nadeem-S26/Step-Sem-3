package Week_9.Lab;
class Car {
    private String brand;
    private String model;
    private double price;
    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Car Details: " + brand + " " + model + " - " + price;
    }
}

public class Cars {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 3200000.00);
        System.out.println(car1);
        System.out.println("Class Name: " + car1.getClass().getName());
    }
}