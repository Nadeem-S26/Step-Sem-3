package Week_4.Assignment;
import java.util.Random;
class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;
    public BankAccount() {
        this.accountHolder = "Unknown";
        this.accountNumber = 0;
        this.balance = 0.0;
    }
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = generateRandomAccountNumber();
        this.balance = 0.0;
    }
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = generateRandomAccountNumber();
        this.balance = balance;
    }
    private int generateRandomAccountNumber() {
        Random rand = new Random();
        return 100000 + rand.nextInt(900000); 
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs. " + amount + " to " + accountHolder + "'s account.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew Rs. " + amount + " from " + accountHolder + "'s account.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
        System.out.println("---------------------------");
    }
}
public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount("Nadeem");
        BankAccount acc3 = new BankAccount("Aisha", 5000.0);
        acc1.displayAccount();
        acc2.displayAccount();
        acc3.displayAccount();
        acc2.deposit(1500.0);
        acc2.withdraw(500.0);
        acc2.displayAccount();
        acc3.withdraw(6000.0);
        acc3.deposit(2000.0);
        acc3.displayAccount();
    }
}