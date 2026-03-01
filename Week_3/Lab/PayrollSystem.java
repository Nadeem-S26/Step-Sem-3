package Week_3.Lab;
class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int totalEmployees = 0;
    private static int empCounter = 0;
    public Employee(String empName, String department, double baseSalary) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = baseSalary;
        this.empType = "Full-Time";
        totalEmployees++;
    }
    public Employee(String empName, String department, double hourlyRate, int hoursWorked) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = hourlyRate * hoursWorked;
        this.empType = "Part-Time";
        totalEmployees++;
    }
    public Employee(String empName, String department, double fixedAmount, boolean isContract) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = fixedAmount;
        this.empType = "Contract";
        totalEmployees++;
    }
    public double calculateSalary(double bonus) {
        if (empType.equals("Full-Time")) {
            return baseSalary + bonus;
        }
        return baseSalary;
    }
    public double calculateSalary() {
        return baseSalary;
    }
    public double calculateTax(double salary) {
        switch (empType) {
            case "Full-Time":
                return salary * 0.20;
            case "Part-Time":
                return salary * 0.10;
            case "Contract":
                return salary * 0.15;
            default:
                return 0.0;
        }
    }
    public void generatePaySlip(double bonus) {
        double salary = empType.equals("Full-Time") ? calculateSalary(bonus) : calculateSalary();
        double tax = calculateTax(salary);
        System.out.println("----- Pay Slip -----");
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Department: " + department);
        System.out.println("Type: " + empType);
        System.out.println("Salary: ₹" + salary);
        System.out.println("Tax Deducted: ₹" + tax);
        System.out.println("Net Pay: ₹" + (salary - tax));
        System.out.println();
    }
    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Department: " + department);
        System.out.println("Type: " + empType);
        System.out.println("Base Salary: ₹" + baseSalary);
        System.out.println();
    }
    public static String generateEmpId() {
        empCounter++;
        return "EMP" + String.format("%03d", empCounter);
    }
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
}
public class PayrollSystem {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Zen", "Development", 50000.0); 
        Employee emp2 = new Employee("Lee", "Support", 300.0, 80);
        Employee emp3 = new Employee("Doe", "Consulting", 40000.0, true); 
        Employee.displayTotalEmployees();
        emp1.displayEmployeeInfo();
        emp2.displayEmployeeInfo();
        emp3.displayEmployeeInfo();
        emp1.generatePaySlip(10000);
        emp2.generatePaySlip(0);
        emp3.generatePaySlip(0);
    }
}