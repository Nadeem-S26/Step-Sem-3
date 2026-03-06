package Week_7.Lab;
public class FoodDeliveryApp {
    public void calculateDeliveryCharge(double distance) {
        double charge = distance * 5; 
        System.out.println("Basic Delivery Charge: " + charge);
    }
    public void calculateDeliveryCharge(double distance, boolean isPriority) {
        double charge = distance * 5;
        if (isPriority) {
            charge += 10; 
        }
        System.out.println("Premium Delivery Charge: " + charge);
    }
    public void calculateDeliveryCharge(double distance, int numberOfOrders) {
        double charge = distance * 5;
        if (numberOfOrders > 5) {
            charge -= 5; 
        }
        System.out.println("Group Delivery Charge: " + charge);
    }
    public void calculateDeliveryCharge(double distance, double discountPercentage, boolean isFreeDelivery) {
        double charge = distance * 5;
        charge -= charge * (discountPercentage / 100);
        if (isFreeDelivery) {
            charge = 0;
        }
        System.out.println("Festival Special Delivery Charge: " + charge);
    }
    public static void main(String[] args) {
        FoodDeliveryApp app = new FoodDeliveryApp();
        app.calculateDeliveryCharge(10);
        app.calculateDeliveryCharge(10, true);
        app.calculateDeliveryCharge(10, 6);
        app.calculateDeliveryCharge(10, 20, true);
    }
}