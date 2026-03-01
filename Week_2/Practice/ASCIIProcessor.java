package Week_2.Practice;
import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("\n=== ASCII Analysis ===");
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int ascii = (int) ch;
            System.out.println("Character: '" + ch + "' | ASCII: " + ascii);
            System.out.println("Type: " + classifyCharacter(ch));

            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                System.out.println("Uppercase: '" + upper + "' | ASCII: " + (int) upper);
                System.out.println("Lowercase: '" + lower + "' | ASCII: " + (int) lower);
                System.out.println("ASCII Difference: " + Math.abs(upper - lower));
            }

            System.out.println("----------------------");
        }
        System.out.println("\n=== ASCII Art ===");
        int[] asciiArray = stringToASCII(input);
        for (int code : asciiArray) {
            System.out.print((char) code + " ");
        }
        System.out.println();
        // Caesar Cipher
        System.out.println("\n=== Caesar Cipher (Shift by 3) ===");
        String ciphered = caesarCipher(input, 3);
        System.out.println("Encrypted: " + ciphered);

        sc.close();
    }

    // Method to classify character type
    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        else if (Character.isLowerCase(ch)) return "Lowercase Letter";
        else if (Character.isDigit(ch)) return "Digit";
        else return "Special Character";
    }

    // Method to toggle case using ASCII
    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return (char) (ch + 32);
        else if (Character.isLowerCase(ch)) return (char) (ch - 32);
        else return ch;
    }

    // Method to implement Caesar cipher
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char shifted = (char) ((ch - base + shift) % 26 + base);
                result.append(shifted);
            } else {
                result.append(ch); // leave digits and symbols unchanged
            }
        }
        return result.toString();
    }

    // Method to convert string to ASCII array
    public static int[] stringToASCII(String text) {
        int[] asciiValues = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            asciiValues[i] = (int) text.charAt(i);
        }
        return asciiValues;
    }

    // Method to convert ASCII array back to string
    public static String asciiToString(int[] asciiValues) {
        StringBuilder result = new StringBuilder();
        for (int code : asciiValues) {
            result.append((char) code);
        }
        return result.toString();
    }

}
