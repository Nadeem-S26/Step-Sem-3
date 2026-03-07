package Week_8.Lab;
abstract class Employee {
    protected String name;
    protected double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public abstract double calculateBonus();
}
interface Payable {
    void generatePaySlip();
}
class Manager extends Employee implements Payable {
    private String department;
    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }
    @Override
    public double calculateBonus() {
        return salary * 0.20;
    }
    @Override
    public void generatePaySlip() {
        System.out.println("----- Pay Slip -----");
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.println("Salary     : Rs." + salary);
        System.out.println("Bonus      : Rs." + calculateBonus());
        System.out.println();
    }
}
public class PayrollDemo {
    public static void main(String[] args) {
        Manager mgr = new Manager("Nadeem Syed", 85000.00, "Engineering");
        mgr.generatePaySlip();
    }
}