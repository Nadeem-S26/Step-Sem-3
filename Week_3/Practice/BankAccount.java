package Week_3.Practice;
public class BankAccount {
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;
    private String accountNumber;
    private String accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        totalAccounts++;
    }
    public static void setBankName(String name) {
        bankName = name;
    }
    public static void setInterestRate(double rate) {
        interestRate = rate;
    }
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited ₹" + amount);
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance for " + accountHolder);
        }
    }
    public double calculateInterest() {
        return balance * (interestRate / 100);
    }
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
        System.out.println("Interest Earned: ₹" + calculateInterest());
        System.out.println("-----------------------------");
    }
    public static void main(String[] args) {
        BankAccount.setBankName("SRM National Bank");
        BankAccount.setInterestRate(5.0);
        BankAccount acc1 = new BankAccount("ACC1001", "Nadeem", 10000);
        BankAccount acc2 = new BankAccount("ACC1002", "Aisha", 15000);
        BankAccount acc3 = new BankAccount("ACC1003", "Ravi", 20000);
        acc1.deposit(2000);
        acc2.withdraw(5000);
        acc3.deposit(1000);
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();
        BankAccount.displayBankInfo();
    }
}