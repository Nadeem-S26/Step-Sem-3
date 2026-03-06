package Week_6.Lab;
class Phone {
    protected String brand;
    protected String model;
    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone constructor called");
    }
    public void displayPhoneDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }
}
class SmartPhone extends Phone {
    private String operatingSystem;
    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model); // Call parent constructor
        this.operatingSystem = operatingSystem;
        System.out.println("SmartPhone constructor called");
    }
    public void displaySmartPhoneDetails() {
        displayPhoneDetails();
        System.out.println("Operating System: " + operatingSystem);
    }
}
public class ConstructorDemo {
    public static void main(String[] args) {
        System.out.println("Creating SmartPhone object...");
        SmartPhone myPhone = new SmartPhone("Samsung", "Galaxy S23", "Android");
        myPhone.displaySmartPhoneDetails();
    }
}