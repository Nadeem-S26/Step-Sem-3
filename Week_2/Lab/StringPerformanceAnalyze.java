package Week_2.Lab;
import java.util.Scanner;
public class StringPerformanceAnalyze {
    public static long stringConcat(int iterations) {
        long start = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "abc";
        }
        long end = System.currentTimeMillis();
        System.out.println("String Concatenation Length: " + result.length());
        return end - start;
    }
    public static long stringBuilderConcat(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("abc");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder Length: " + sb.length());
        return end - start;
    }
    public static long stringBufferConcat(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append("abc");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer Length: " + sbuf.length());
        return end - start;
    }
    public static void displayComparison(long timeString, long timeBuilder, long timeBuffer) {
        System.out.println("\nPerformance Comparison:");
        System.out.println("| Method Used       | Time Taken (ms)      | Memory Efficiency |");
        System.out.printf("| String (+)        | %-20d | Low               |\n", timeString);
        System.out.printf("| StringBuilder     | %-20d | High              |\n", timeBuilder);
        System.out.printf("| StringBuffer      | %-20d | High (Thread-safe)|\n", timeBuffer);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int iterations = sc.nextInt();
        long timeString = stringConcat(iterations);
        long timeBuilder = stringBuilderConcat(iterations);
        long timeBuffer = stringBufferConcat(iterations);
        displayComparison(timeString, timeBuilder, timeBuffer);
        sc.close();
    }
}
