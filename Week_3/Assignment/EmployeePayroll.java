package Week_3.Assignment;
import java.util.Arrays;
public class EmployeePayroll {
    public static void main(String[] args) {
        Employee.companyName = "Aurora Tech Pvt Ltd";
        Employee.workingDaysPerMonth = 30;
        Department eng = new Department("D01", "Engineering", null, 10, 2_000_000);
        Department hr  = new Department("D02", "Human Resources", null, 5, 500_000);
        FullTimeEmployee e1 = new FullTimeEmployee("E001", "Aarav", "Engineering", "SDE-II", 120000.0, "2023-05-12");
        FullTimeEmployee e2 = new FullTimeEmployee("E002", "Meera", "Engineering", "SDE-I", 80000.0, "2024-01-10");
        PartTimeEmployee  e3 = new PartTimeEmployee("E003", "Rohit", "HR", "Coordinator (PT)", 600.0, "2024-07-01"); 
        ContractEmployee  e4 = new ContractEmployee("E004", "Isha", "HR", "Consultant", 90000.0, "2024-03-05");
        eng.setManager(e1);
        hr.setManager(e4);
        eng.addEmployee(e1);
        eng.addEmployee(e2);
        hr.addEmployee(e3);
        hr.addEmployee(e4);
        for (int d = 1; d <= 30; d++) {
            e1.markAttendance(d, d <= 15);  
            e2.markAttendance(d, d != 7 && d != 14 && d != 21); 
            e4.markAttendance(d, true);
        }
        for (int d = 1; d <= 30; d++) {
            int hours = (d % 2 == 0) ? 5 : 0; 
            e3.logHours(d, hours);
        }
        e1.requestLeave(16, 18, "Sick Leave"); 
        e2.requestLeave(7, 7, "Personal");     
        e4.requestLeave(10, 12, "Travel");  
        e1.setPerformanceRating(4);
        e2.setPerformanceRating(5);
        e3.setPerformanceRating(4);
        e4.setPerformanceRating(3);
        System.out.println(e1.generatePaySlip());
        System.out.println(e2.generatePaySlip());
        System.out.println(e3.generatePaySlip());
        System.out.println(e4.generatePaySlip());
        Department[] depts = new Department[]{eng, hr};
        double companyPayroll = Employee.calculateCompanyPayroll(depts);
        System.out.println("Company Payroll (This Month): " + companyPayroll);
        double[][] deptExpenses = Employee.getDepartmentWiseExpenses(depts);
        System.out.println("\nDepartment-wise Expenses:");
        for (double[] row : deptExpenses) {
            int idx = (int) row[0];
            System.out.printf(" - %s: %.2f%n", depts[idx].deptName, row[1]);
        }
        String attendanceReport = Employee.getAttendanceReport(new Employee[]{e1, e2, e3, e4});
        System.out.println("\nAttendance Report:\n" + attendanceReport);
    }
}
abstract class Employee {
    protected String empId;
    protected String empName;
    protected String department;
    protected String designation;
    protected double baseSalary; 
    protected String joinDate;
    protected boolean[] attendanceRecord = new boolean[30];    
    protected boolean[] approvedLeaveDays = new boolean[30];   
    protected int performanceRating = 3;
    protected int leaveBalance;
    public static int totalEmployees = 0;
    public static String companyName = "Company";
    public static double totalSalaryExpense = 0.0;
    public static int workingDaysPerMonth = 30;
    public Employee(String empId, String empName, String department, String designation, double baseSalary, String joinDate) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
        totalEmployees++;
    }
    public boolean markAttendance(int day, boolean present) {
        if (day < 1 || day > 30) return false;
        attendanceRecord[day - 1] = present;
        return true;
    }
    public boolean requestLeave(int startDay, int endDay, String reason) {
        if (startDay < 1 || endDay > 30 || startDay > endDay) return false;
        int daysRequested = endDay - startDay + 1;
        int paidDays = getPaidLeaveAllocation(daysRequested);
        for (int d = startDay; d <= endDay; d++) {
            boolean paid = (paidDays-- > 0);
            approvedLeaveDays[d - 1] = paid;
            if (!paid) {
                attendanceRecord[d - 1] = false;
            }
        }
        return true;
    }
    protected int getPaidLeaveAllocation(int daysRequested) {
        int paid = Math.max(0, Math.min(leaveBalance, daysRequested));
        leaveBalance -= paid;
        return paid;
    }
    public void setPerformanceRating(int rating) {
        if (rating >= 1 && rating <= 5) this.performanceRating = rating;
    }
    protected int countPresentDays() {
        int c = 0;
        for (boolean b : attendanceRecord) if (b) c++;
        return c;
    }
    protected int countApprovedPaidLeaveDays() {
        int c = 0;
        for (boolean b : approvedLeaveDays) if (b) c++;
        return c;
    }
    protected int payableDaysForMonth() {
        int days = countPresentDays() + countApprovedPaidLeaveDays();
        return Math.min(days, workingDaysPerMonth);
    }

    protected double attendancePercentage() {
        int attended = countPresentDays();
        return (workingDaysPerMonth == 0) ? 0.0 : (attended * 100.0 / workingDaysPerMonth);
    }

    public String generatePaySlip() {
        double salary = calculateSalary();
        double bonus  = calculateBonus();
        double total  = salary + bonus;
        return new StringBuilder()
                .append("\n========== Pay Slip ==========\n")
                .append("Company        : ").append(companyName).append("\n")
                .append("Employee ID    : ").append(empId).append("\n")
                .append("Name           : ").append(empName).append("\n")
                .append("Department     : ").append(department).append("\n")
                .append("Designation    : ").append(designation).append("\n")
                .append("Join Date      : ").append(joinDate).append("\n")
                .append("Attendance     : ").append(String.format("%.2f%%", attendancePercentage())).append("\n")
                .append("Perf. Rating   : ").append(performanceRating).append("/5\n")
                .append("------------------------------\n")
                .append("Base Salary    : ").append(String.format("%.2f", baseSalary)).append("\n")
                .append("Monthly Pay    : ").append(String.format("%.2f", salary)).append("\n")
                .append("Bonus          : ").append(String.format("%.2f", bonus)).append("\n")
                .append("TOTAL PAY      : ").append(String.format("%.2f", total)).append("\n")
                .append("==============================\n")
                .toString();
    }

    public abstract double calculateSalary();
    public abstract double calculateBonus();
    public static double calculateCompanyPayroll(Department[] departments) {
        totalSalaryExpense = 0.0;
        if (departments == null) return 0.0;
        for (Department d : departments) {
            if (d == null) continue;
            for (Employee e : d.employees) {
                if (e == null) continue;
                totalSalaryExpense += (e.calculateSalary() + e.calculateBonus());
            }
        }
        return totalSalaryExpense;
    }
    public static double[][] getDepartmentWiseExpenses(Department[] departments) {
        if (departments == null) return new double[0][0];
        double[][] out = new double[departments.length][2];
        for (int i = 0; i < departments.length; i++) {
            Department d = departments[i];
            double expense = 0.0;
            if (d != null) {
                for (Employee e : d.employees) {
                    if (e != null) expense += (e.calculateSalary() + e.calculateBonus());
                }
            }
            out[i][0] = i;
            out[i][1] = expense;
        }
        return out;
    }
    public static String getAttendanceReport(Employee[] employees) {
        if (employees == null || employees.length == 0) return "No employees.";
        StringBuilder sb = new StringBuilder();
        for (Employee e : employees) {
            if (e == null) continue;
            sb.append(String.format("%s (%s): %.2f%% present%n", e.empName, e.empId, e.attendancePercentage()));
        }
        return sb.toString();
    }
}
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String empId, String empName, String department, String designation, double baseSalary, String joinDate) {
        super(empId, empName, department, designation, baseSalary, joinDate);
        this.leaveBalance = 12;
    }

    @Override
    public double calculateSalary() {
        int payableDays = payableDaysForMonth();
        double dailyRate = baseSalary / workingDaysPerMonth;
        return round2(dailyRate * payableDays);
    }

    @Override
    public double calculateBonus() {
        double att = attendancePercentage();
        double bonusPct = 0.0;
        if (att >= 95.0) bonusPct += 0.10;
        else if (att >= 85.0) bonusPct += 0.05;
        if (performanceRating >= 4) bonusPct += 0.05;
        return round2(baseSalary * bonusPct);
    }

    private double round2(double v) { return Math.round(v * 100.0) / 100.0; }
}

class PartTimeEmployee extends Employee {
    private int[] hoursWorked = new int[30];

    public PartTimeEmployee(String empId, String empName, String department, String designation, double hourlyRate, String joinDate) {
        super(empId, empName, department, designation, hourlyRate, joinDate);
        this.leaveBalance = 6;
    }
    public boolean logHours(int day, int hours) {
        if (day < 1 || day > 30 || hours < 0) return false;
        hoursWorked[day - 1] = hours;
        markAttendance(day, hours > 0);
        return true;
    }
    public int totalHours() {
        int sum = 0;
        for (int h : hoursWorked) sum += h;
        int paidLeaveDays = countApprovedPaidLeaveDays();
        if (paidLeaveDays > 0) {
            double avg = averageWorkedHoursOnWorkedDays();
            sum += (int)Math.round(avg * paidLeaveDays);
        }
        return sum;
    }
    private double averageWorkedHoursOnWorkedDays() {
        int sum = 0, days = 0;
        for (int i = 0; i < hoursWorked.length; i++) {
            if (hoursWorked[i] > 0) {
                sum += hoursWorked[i];
                days++;
            }
        }
        return days == 0 ? 0.0 : (sum * 1.0 / days);
    }

    @Override
    public double calculateSalary() {
        double salary = baseSalary * totalHours();
        return round2(salary);
    }

    @Override
    public double calculateBonus() {
        int activeDays = 0;
        for (boolean b : attendanceRecord) if (b) activeDays++;
        double bonus = 0.0;
        if (activeDays >= 15) bonus += baseSalary * 10;
        if (performanceRating >= 4) bonus += baseSalary * 10;
        return round2(bonus);
    }
    private double round2(double v) { return Math.round(v * 100.0) / 100.0; }
}
class ContractEmployee extends Employee {
    public ContractEmployee(String empId, String empName, String department, String designation, double monthlyFixed, String joinDate) {
        super(empId, empName, department, designation, monthlyFixed, joinDate);
        this.leaveBalance = 0; // unpaid
    }
    @Override
    protected int getPaidLeaveAllocation(int daysRequested) {
        return 0;
    }

    @Override
    public double calculateSalary() {
        int unpaidDays = 0;
        for (int i = 0; i < 30; i++) {
            if (!attendanceRecord[i] && !approvedLeaveDays[i]) unpaidDays++;
        }
        if (unpaidDays > 5) {
            double daily = baseSalary / workingDaysPerMonth;
            int excess = unpaidDays - 5;
            return round2(Math.max(0.0, baseSalary - daily * excess));
        }
        return round2(baseSalary);
    }
    @Override
    public double calculateBonus() {
        return 0.0;
    }

    private double round2(double v) { return Math.round(v * 100.0) / 100.0; }
}
class Department {
    public String deptId;
    public String deptName;
    public Employee manager;
    public Employee[] employees;
    public double budget;
    private int idx = 0;
    public Department(String deptId, String deptName, Employee manager, int capacity, double budget) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.manager = manager;
        this.employees = new Employee[capacity];
        this.budget = budget;
    }
    public boolean addEmployee(Employee e) {
        if (e == null) return false;
        if (idx >= employees.length) return false;
        employees[idx++] = e;
        return true;
    }
    public void setManager(Employee m) {
        this.manager = m;
    }
    public double totalExpensesThisMonth() {
        double sum = 0.0;
        for (Employee e : employees) {
            if (e != null) sum += e.calculateSalary() + e.calculateBonus();
        }
        return sum;
    }
    @Override
    public String toString() {
        return "Department{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", manager=" + (manager == null ? "N/A" : manager.empName) +
                ", headcount=" + Arrays.stream(employees).filter(x -> x != null).count() +
                ", budget=" + budget +
                '}';
    }
}