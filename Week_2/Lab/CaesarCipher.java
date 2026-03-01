package Week_2.Lab;

import java.util.Scanner;
public class CaesarCipher {
    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char e = (char) ((ch - 'A' + shift) % 26 + 'A');
                encrypted.append(e);
            } else if (Character.isLowerCase(ch)) {
                char e = (char) ((ch - 'a' + shift) % 26 + 'a');
                encrypted.append(e);
            } else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }
    public static void displayAsciiComparison(String original, String encrypted) {
        System.out.println("\nCharacter | ASCII (Original) | ASCII (Encrypted)");
        for (int i = 0; i < original.length(); i++) {
            System.out.printf("    %c     |       %3d       |       %3d\n",
                    original.charAt(i),
                    (int) original.charAt(i),
                    (int) encrypted.charAt(i));
        }
    }
    public static boolean validate(String original, String decrypted) {
        return original.equals(decrypted);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to encrypt: ");
        String inputText = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();
        String encryptedText = encrypt(inputText, shift);
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("\nOriginal Text: " + inputText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
        displayAsciiComparison(inputText, encryptedText);
        System.out.println("\nValidation Result: " +(validate(inputText, decryptedText) ? "Success" : "Failed"));
        sc.close();
    }
}

