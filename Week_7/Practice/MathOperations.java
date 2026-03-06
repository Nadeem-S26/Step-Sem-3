package Week_7.Practice;
public class MathOperations {
    public static int add(int a, int b) {
        return a + b;
    } 
    public static double add(double a, double b) {
        return a + b;
    }
    public static int add(int... values) {
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return sum;
    } 
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static double multiply(double a, double b, double c) {
        return a * b * c;
    }
    public static String concat(String a, String b) {
        return a + b;
    }
    public static String concat(String a, String b, String c) {
        return a + b + c;
    }
    public static void main(String[] args) {  
        System.out.println("add(2, 3) = " + add(2, 3));
        System.out.println("add(2.5, 4.5) = " + add(2.5, 4.5));
        System.out.println("add(1, 2, 3, 4) = " + add(1, 2, 3, 4));
        System.out.println("multiply(3, 4) = " + multiply(3, 4));
        System.out.println("multiply(1.2, 2.3, 3.4) = " + multiply(1.2, 2.3, 3.4));
        System.out.println("concat(\"Hello\", \"World\") = " + concat("Hello", "World"));
        System.out.println("concat(\"A\", \"B\", \"C\") = " + concat("A", "B", "C"));
    } 
}