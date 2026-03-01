package Week_3.Assignment;
import java.util.Random;
class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;
    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";
    public PersonalAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }
    public void addIncome(double amount, String description) {
        if (amount > 0) {
            currentBalance += amount;
            totalIncome += amount;
            System.out.println(accountHolderName + " received income: Rs. " + amount + " (" + description + ")");
        } else {
            System.out.println("Invalid income amount.");
        }
    }
    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            totalExpenses += amount;
            System.out.println(accountHolderName + " spent: Rs. " + amount + " (" + description + ")");
        } else {
            System.out.println("Invalid expense or insufficient balance.");
        }
    }
    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }
    public void displayAccountSummary() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: Rs. " + currentBalance);
        System.out.println("Total Income: Rs. " + totalIncome);
        System.out.println("Total Expenses: Rs. " + totalExpenses);
        System.out.println("Savings: Rs. " + calculateSavings());
        System.out.println("---------------------------");
    }
    public static void setBankName(String name) {
        bankName = name;
    }
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    public static String generateAccountNumber() {
        Random rand = new Random();
        return "AC" + (100000 + rand.nextInt(900000));
    }
}

public class FinanceManager {
    public static void main(String[] args) {
        PersonalAccount.setBankName("National Finance Bank");
        PersonalAccount acc1 = new PersonalAccount("Nadeem");
        PersonalAccount acc2 = new PersonalAccount("Aisha");
        PersonalAccount acc3 = new PersonalAccount("Rahul");
        acc1.addIncome(5000, "Salary");
        acc1.addExpense(1500, "Groceries");
        acc2.addIncome(8000, "Freelance Project");
        acc2.addExpense(2000, "Rent");
        acc3.addIncome(10000, "Business Profit");
        acc3.addExpense(3000, "Travel");
        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();
        System.out.println("Total Accounts Created: " + PersonalAccount.getTotalAccounts());
        System.out.println("Bank Name (shared): " + "National Finance Bank");
        System.out.println("Balances are unique per account:");
        System.out.println("Nadeem's Balance: Rs. " + acc1.calculateSavings());
        System.out.println("Aisha's Balance: Rs. " + acc2.calculateSavings());
        System.out.println("Rahul's Balance: Rs. " + acc3.calculateSavings());
    }
}