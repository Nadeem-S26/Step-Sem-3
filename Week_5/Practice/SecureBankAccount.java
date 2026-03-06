package Week_5.Practice;
public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;
    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        if (!isLocked) {
            return balance;
        } else {
            System.out.println("Account is locked. Cannot retrieve balance.");
            return -1;
        }
    }
    public boolean isAccountLocked() {
        return isLocked;
    }
    public boolean setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            System.out.println("PIN changed successfully.");
            return true;
        } else {
            System.out.println("Old PIN incorrect. Cannot change PIN.");
            return false;
        }
    }
    public boolean validatePin(int enteredPin) {
        if (isLocked) {
            System.out.println("Account is locked.");
            return false;
        }
        if (this.pin == enteredPin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }
    public void unlockAccount(int correctPin) {
        if (this.pin == correctPin) {
            isLocked = false;
            resetFailedAttempts();
            System.out.println("Account unlocked successfully.");
        } else {
            System.out.println("Incorrect PIN. Cannot unlock account.");
        }
    }
    public void deposit(double amount, int pin) {
        if (validatePin(pin)) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Invalid PIN. Deposit failed.");
        }
    }
    public void withdraw(double amount, int pin) {
        if (validatePin(pin)) {
            if (amount <= balance && (balance - amount) >= MIN_BALANCE) {
                balance -= amount;
                System.out.println("Withdrew " + amount + ". New Balance: " + balance);
            } else {
                System.out.println("Insufficient balance or minimum balance requirement violated.");
            }
        } else {
            System.out.println("Invalid PIN. Withdrawal failed.");
        }
    }
    public void transfer(SecureBankAccount target, double amount, int pin) {
        if (validatePin(pin)) {
            if (amount <= balance && (balance - amount) >= MIN_BALANCE) {
                balance -= amount;
                target.balance += amount;
                System.out.println("Transferred " + amount + " to account " + target.accountNumber);
            } else {
                System.out.println("Insufficient balance or minimum balance requirement violated.");
            }
        } else {
            System.out.println("Invalid PIN. Transfer failed.");
        }
    }
    private void lockAccount() {
        isLocked = true;
        System.out.println("Account locked due to multiple failed attempts.");
    }
    private void resetFailedAttempts() {
        failedAttempts = 0;
    }
    private void incrementFailedAttempts() {
        failedAttempts++;
        System.out.println("Failed attempt #" + failedAttempts);
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        }
    }
    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("ACC123", 5000);
        SecureBankAccount acc2 = new SecureBankAccount("ACC456", 3000);
        acc1.setPin(0, 1234);
        acc2.setPin(0, 5678);
        acc1.deposit(500, 1234);
        acc1.withdraw(1000, 1234);
        acc1.transfer(acc2, 500, 1234);
        acc1.withdraw(100, 1111);
        acc1.withdraw(100, 2222);  
        acc1.withdraw(100, 3333); 
        acc1.getBalance(); 
        acc1.unlockAccount(1234);
        acc1.getBalance(); 
    }
}