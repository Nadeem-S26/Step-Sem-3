package Week_1.Assignment;

import java.util.Scanner;
public class UniqCharacterFinder {
    // Method to find the length of the string without using length()
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }
    // Method to find unique characters using charAt()
    public static char[] findUniqueCharacters(String text) {
        int len = text.length();
        char[] unique = new char[len];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[uniqueCount] = current;
                uniqueCount++;
            }
        }
        // Create final array with exact size
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }
        return result;
    }
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        char[] uniqueChars = findUniqueCharacters(input);
        System.out.println("Unique characters in the string:");
        for (char ch : uniqueChars) {
            System.out.print(ch + " ");
        }
        sc.close();
    }
}