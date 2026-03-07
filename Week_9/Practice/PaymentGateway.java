package Week_9.Practice;
class Payment {
    public void pay() {
        System.out.println("Generic payment");
    }
}
class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Paid using Credit Card");
    }
}
class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Paid using Wallet");
    }
}
public class PaymentGateway {
    public static void main(String[] args) {
        Payment[] payments = { new CreditCardPayment(),new WalletPayment()};
        for (Payment p : payments) {
            System.out.println("Payment Type: " + p.getClass().getSimpleName());
            p.pay();
        }
    }
}