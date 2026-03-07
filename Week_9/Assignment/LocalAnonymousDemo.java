package Week_9.Assignment;
interface Discount {
    double apply(double amount);
}
class Payment {
    public void processTransaction(double amount) {
        class Validator {
            public boolean isValid(double amt) {
                return amt > 0;
            }
        }
        Validator validator = new Validator();
        if (!validator.isValid(amount)) {
            System.out.println("Invalid payment amount.");
            return;
        }
        Discount discount = new Discount() {
            @Override
            public double apply(double amt) {
                return amt * 0.90;
            }
        };
        double finalAmount = discount.apply(amount);
        System.out.println("Original Amount: Rs." + amount);
        System.out.println("Final Amount after Discount: Rs." + finalAmount);
    }
}
public class LocalAnonymousDemo {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.processTransaction(1000.00);
    }
}