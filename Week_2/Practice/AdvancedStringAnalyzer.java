package Week_2.Practice;
import java.util.Scanner;
public class AdvancedStringAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ADVANCED STRING ANALYZER ===");
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        performAllComparisons(str1, str2);
        double similarity = calculateSimilarity(str1, str2);
        System.out.printf("Similarity Percentage: %.2f%%\n", similarity);
        analyzeMemoryUsage(str1, str2);
        String[] inputs = {str1, str2};
        String optimized = optimizedStringProcessing(inputs);
        System.out.println("Optimized String Output: " + optimized);
        demonstrateStringIntern();
        scanner.close();
    }
    // Method to perform all comparison types
    public static void performAllComparisons(String str1, String str2) {
        System.out.println("\n=== COMPARISON ANALYSIS ===");
        System.out.println("Reference Equality (==): " + (str1 == str2));
        System.out.println("Content Equality (equals): " + str1.equals(str2));
        System.out.println("Case-Insensitive Equality: " + str1.equalsIgnoreCase(str2));
        System.out.println("Lexicographic Comparison: " + str1.compareTo(str2));
        System.out.println("Case-Insensitive Lexicographic Comparison: " + str1.compareToIgnoreCase(str2));
    }
    // Method to calculate string similarity percentage using Levenshtein distance
    public static double calculateSimilarity(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int j = 0; j <= len2; j++) dp[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int cost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(
                    dp[i - 1][j] + 1,
                    dp[i][j - 1] + 1),
                    dp[i - 1][j - 1] + cost
                );
            }
        }
        int maxLen = Math.max(len1, len2);
        int distance = dp[len1][len2];
        return ((maxLen - distance) / (double) maxLen) * 100;
    }
    // Method to analyze string memory usage (approximate)
    public static void analyzeMemoryUsage(String... strings) {
        System.out.println("\n=== MEMORY USAGE ANALYSIS ===");
        for (String s : strings) {
            int estimatedBytes = 40 + 2 * s.length(); // Rough estimate: object overhead + 2 bytes per char
            System.out.println("String: \"" + s + "\" | Estimated Memory: " + estimatedBytes + " bytes");
        }
    }
    // Method to optimize string operations using StringBuilder
    public static String optimizedStringProcessing(String[] inputs) {
        StringBuilder sb = new StringBuilder();
        for (String s : inputs) {
            sb.append(s.trim().toUpperCase()).append(" | ");
        }
        return sb.toString().replaceAll(" \\| $", ""); // Remove trailing separator
    }
    // Method to demonstrate intern() method
    public static void demonstrateStringIntern() {
        System.out.println("\n=== STRING INTERN DEMO ===");
        String a = new String("Java");
        String b = "Java";
        String c = a.intern();
        System.out.println("a == b: " + (a == b));       // false
        System.out.println("c == b: " + (c == b));       // true
        System.out.println("a.equals(b): " + a.equals(b)); // true
    }
}
