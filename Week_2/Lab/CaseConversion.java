package Week_2.Lab;
import java.util.*;
public class CaseConversion {
    public static char toUpper(char ch) {
        if (ch >= 97 && ch <= 122) { // a-z
            return (char) (ch - 32);
        }
        return ch;
    }
    public static char toLower(char ch) {
        if (ch >= 65 && ch <= 90) { // A-Z
            return (char) (ch + 32);
        }
        return ch;
    }
    public static String convertToUpper(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(toUpper(text.charAt(i)));
        }
        return result.toString();
    }
    public static String convertToLower(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(toLower(text.charAt(i)));
        }
        return result.toString();
    }
    public static String convertToTitleCase(String text) {
        StringBuilder result = new StringBuilder();
        boolean newWord = true;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                result.append(ch);
                newWord = true;
            } else {
                if (newWord) {
                    result.append(toUpper(ch));
                    newWord = false;
                } else {
                    result.append(toLower(ch));
                }
            }
        }
        return result.toString();
    }
    public static void compareWithBuiltIn(String original, String upper, String lower) {
        String builtInUpper = original.toUpperCase();
        String builtInLower = original.toLowerCase();
        System.out.println("\nComparison:");
        System.out.println("Manual Upper == Built-in Upper? " + upper.equals(builtInUpper));
        System.out.println("Manual Lower == Built-in Lower? " + lower.equals(builtInLower));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text:");
        String text = sc.nextLine();
        String manualUpper = convertToUpper(text);
        String manualLower = convertToLower(text);
        String manualTitle = convertToTitleCase(text);
        System.out.println("| Conversion Type | Result :");
        System.out.printf("| Original        | %-25s |\n", text);
        System.out.printf("| Uppercase       | %-25s |\n", manualUpper);
        System.out.printf("| Lowercase       | %-25s |\n", manualLower);
        System.out.printf("| Title Case      | %-25s |\n", manualTitle);
        compareWithBuiltIn(text, manualUpper, manualLower);
        sc.close();
    }
}
