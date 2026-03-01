package Week_3.Lab;
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;
    private static int accCounter = 0;
    public static String generateAccountNo() {
        accCounter++;
        return "ACC" + String.format("%03d", accCounter);
    }
    public static void getTotalAccounts() {
        System.out.println("Total number of accounts: " + totalAccounts);
    }
    BankAccount(String accountHolderName, double initialBalance) {
        this.accountNumber = generateAccountNo();
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        totalAccounts++;
    }
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Invalid! Negative Amount");
        } else {
            balance += amount;
            System.out.println("Amount has been deposited successfully");
        }
    }
    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Amount has been withdrawn successfully");
        }
    }
    public void checkBalance() {
        System.out.println("Balance is: " + balance);
    }
    public void displayAccountInfo() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println();
    }
}
public class BankManagementSystem {
    public static void main(String[] args) {
        BankAccount[] acc = new BankAccount[3];
        acc[0] = new BankAccount("Kaze", 12000.0);
        acc[1] = new BankAccount("Kai", 11000.0);
        acc[2] = new BankAccount("Kage", 20000.0);
        BankAccount.getTotalAccounts();
        acc[0].deposit(3000);
        acc[1].withdraw(1000);
        acc[2].checkBalance();
        acc[0].displayAccountInfo();
        acc[1].displayAccountInfo();
        acc[2].displayAccountInfo();
    }
}