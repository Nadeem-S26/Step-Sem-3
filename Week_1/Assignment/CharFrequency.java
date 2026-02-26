package Week_1.Assignment;
import java.util.Scanner;
public class CharFrequency {
    // Method to find frequency of characters and return as 2D array
    public static String[][] findCharFrequencies(String text) {
        int[] freq = new int[256]; // ASCII size
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }
        String[][] result = new String[text.length()][2];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] != 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                freq[ch] = 0; // Mark as processed
                index++;
            }
        }
        String[][] finalResult = new String[index][2];
        for (int i = 0; i < index; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }
        return finalResult;
    }
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] frequencies = findCharFrequencies(input);
        System.out.println("Character Frequencies:");
        System.out.println("----------------------");
        for (String[] pair : frequencies) {
            System.out.println("Char : " + pair[0] + " | Frequency: " + pair[1]);
        }
        sc.close();
    }
}
