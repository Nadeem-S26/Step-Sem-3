package Week_4.Assignment;
class FoodOrder {
    String customerName;
    String foodItem;
    int quantity;
    double price;
    static final double FIXED_RATE = 150.0;
    public FoodOrder() {
        this.customerName = "Unknown";
        this.foodItem = "Unknown";
        this.quantity = 0;
        this.price = 0.0;
    }
    public FoodOrder(String foodItem) {
        this.customerName = "Unknown";
        this.foodItem = foodItem;
        this.quantity = 1;
        this.price = FIXED_RATE;
    }
    public FoodOrder(String customerName, String foodItem, int quantity) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * FIXED_RATE;
    }
    public void printBill() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Food Item: " + foodItem);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: Rs. " + price);
        System.out.println("---------------------------");
    }
}
public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodOrder order1 = new FoodOrder();
        FoodOrder order2 = new FoodOrder("Burger");
        FoodOrder order3 = new FoodOrder("Nadeem", "Pizza", 3);
        order1.printBill();
        order2.printBill();
        order3.printBill();
    }
}