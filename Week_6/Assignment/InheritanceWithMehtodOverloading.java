package Week_6.Assignment;
class BasicMath {
    public int calculate(int a, int b) {
        System.out.println("BasicMath: Adding two integers");
        return a + b;
    }
    public int calculate(int a, int b, int c) {
        System.out.println("BasicMath: Adding three integers");
        return a + b + c;
    }
    public double calculate(double a, double b) {
        System.out.println("BasicMath: Adding two doubles");
        return a + b;
    }
}
class AdvancedMath extends BasicMath {
    public int calculate(int a, int b, boolean multiply) {
        if (multiply) {
            System.out.println("AdvancedMath: Multiplying two integers");
            return a * b;
        } else {
            System.out.println("AdvancedMath: Adding two integers (fallback)");
            return calculate(a, b);
        }
    }
    public double calculate(double base, int exponent) {
        System.out.println("AdvancedMath: Calculating power");
        return Math.pow(base, exponent);
    }
}
public class InheritanceWithMehtodOverloading {
    public static void main(String[] args) {
        AdvancedMath math = new AdvancedMath();
        System.out.println("Result 1: " + math.calculate(5, 3));
        System.out.println("Result 2: " + math.calculate(2, 3, 4));
        System.out.println("Result 3: " + math.calculate(2.5, 3.5));
        System.out.println("Result 4: " + math.calculate(4, 5, true));
        System.out.println("Result 5: " + math.calculate(2.0, 3));
    }
}