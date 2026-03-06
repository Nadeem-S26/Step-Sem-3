package Week_5.Practice;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;
    public EmployeeBean() { }
    public EmployeeBean(String employeeId, String firstName, String lastName, double salary,
                        String department, Date hireDate, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.setSalary(salary);
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }
    public String getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public Date getHireDate() { return hireDate; }
    public boolean isActive() { return isActive; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary must be positive");
        this.salary = salary;
    }
    public void setDepartment(String department) { this.department = department; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
    public void setActive(boolean isActive) { this.isActive = isActive; }
    public String getFullName() {
        return firstName + " " + lastName;
    }
    public long getYearsOfService() {
        long millis = new Date().getTime() - hireDate.getTime();
        return TimeUnit.MILLISECONDS.toDays(millis) / 365;
    }
    public String getFormattedSalary() {
        return NumberFormat.getCurrencyInstance().format(salary);
    }
    public void setFullName(String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length >= 2) {
            this.firstName = parts[0];
            this.lastName = parts[1];
        } else {
            throw new IllegalArgumentException("Full name must include first and last name");
        }
    }
    @Override
    public String toString() {
        return "EmployeeBean{" +
                "employeeId='" + employeeId + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", salary=" + getFormattedSalary() +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                ", isActive=" + isActive +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeBean)) return false;
        EmployeeBean that = (EmployeeBean) o;
        return Objects.equals(employeeId, that.employeeId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
    public static class JavaBeanProcessor {
        public static void printAllProperties(EmployeeBean emp) {
            try {
                var methods = emp.getClass().getMethods();
                for (var m : methods) {
                    if (m.getName().startsWith("get") || m.getName().startsWith("is")) {
                        Object value = m.invoke(emp);
                        String propName = m.getName().replaceFirst("get|is", "");
                        System.out.println(propName + ": " + value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static void copyProperties(EmployeeBean source, EmployeeBean target) {
            try {
                var methods = source.getClass().getMethods();
                for (var m : methods) {
                    if (m.getName().startsWith("get") && !m.getName().equals("getClass")) {
                        Object value = m.invoke(source);
                        String setterName = m.getName().replaceFirst("get", "set");
                        try {
                            var setter = target.getClass().getMethod(setterName, m.getReturnType());
                            setter.invoke(target, value);
                        } catch (NoSuchMethodException ignored) { }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @SuppressWarnings("all")
    public static void main(String[] args) {
        EmployeeBean emp1 = new EmployeeBean("E001", "Alice", "Smith", 75000, "IT", new Date(116, 0, 15), true);
        EmployeeBean emp2 = new EmployeeBean();
        emp2.setEmployeeId("E002");
        emp2.setFullName("Bob Johnson");
        emp2.setSalary(50000);
        emp2.setDepartment("HR");
        emp2.setHireDate(new Date(118, 5, 10));
        emp2.setActive(true);
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println("\nYears of Service: " + emp1.getYearsOfService());
        System.out.println("Formatted Salary: " + emp1.getFormattedSalary());
        JavaBeanProcessor.printAllProperties(emp1);
        JavaBeanProcessor.copyProperties(emp1, emp2);
        System.out.println("\nAfter copying properties:");
        System.out.println(emp2);
    }
}
