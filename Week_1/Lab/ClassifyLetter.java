package Week_1.Lab;
import java.util.Scanner;
public class ClassifyLetter {
    public static String getCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }
    public static String[][] classifyCharacters(String input) {
        int length = input.length();
        String[][] result = new String[length][2];
        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getCharType(ch);
        }
        return result;
    }
    public static void displayTable(String[][] data) {
        System.out.printf("%-10s%-15s%n", "Character", "Type");
        System.out.println("---------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s%-15s%n", row[0], row[1]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] classifiedData = classifyCharacters(input);
        displayTable(classifiedData);
        sc.close();
    }
}
