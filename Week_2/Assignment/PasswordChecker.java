package Week_2.Assignment;
import java.util.Scanner;
import java.util.Random;
public class PasswordChecker {
    // b. Analyze password using ASCII values
    public static int[] analyzePassword(String password) {
        int upper = 0, lower = 0, digit = 0, special = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 65 && ascii <= 90) upper++;
            else if (ascii >= 97 && ascii <= 122) lower++;
            else if (ascii >= 48 && ascii <= 57) digit++;
            else if (ascii >= 33 && ascii <= 126) special++;
        }

        return new int[]{upper, lower, digit, special};
    }
    public static boolean hasCommonPattern(String password) {
        String[] patterns = {"123", "abc", "qwerty", "password", "admin"};
        for (String pattern : patterns) {
            if (password.toLowerCase().contains(pattern)) return true;
        }
        return false;
    }
    public static int calculateScore(String password, int[] counts) {
        int score = 0;
        int lengthBonus = Math.max(0, password.length() - 8) * 2;
        int varietyBonus = 0;

        for (int count : counts) {
            if (count > 0) varietyBonus += 10;
        }

        int penalty = hasCommonPattern(password) ? 15 : 0;

        score = lengthBonus + varietyBonus - penalty;
        return score;
    }

    public static String getStrengthLevel(int score) {
        if (score <= 20) return "Weak";
        else if (score <= 50) return "Medium";
        else return "Strong";
    }
    public static String generateStrongPassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+[]{}|;:,.<>?";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(upper.charAt(rand.nextInt(upper.length())));
        sb.append(lower.charAt(rand.nextInt(lower.length())));
        sb.append(digits.charAt(rand.nextInt(digits.length())));
        sb.append(special.charAt(rand.nextInt(special.length())));
        String allChars = upper + lower + digits + special;
        for (int i = 4; i < length; i++) {
            sb.append(allChars.charAt(rand.nextInt(allChars.length())));
        }
        char[] passwordArray = sb.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int j = rand.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }

        return new String(passwordArray);
    }
    public static void displayResults(String[] passwords) {
        System.out.printf("%-15s %-7s %-7s %-7s %-7s %-7s %-7s %-10s\n",
                "Password", "Length", "Upper", "Lower", "Digit", "Special", "Score", "Strength");
        System.out.println("--------------------------------------------------------------------------");

        for (String pwd : passwords) {
            int[] counts = analyzePassword(pwd);
            int score = calculateScore(pwd, counts);
            String level = getStrengthLevel(score);

            System.out.printf("%-15s %-7d %-7d %-7d %-7d %-7d %-7d %-10s\n",
                    pwd, pwd.length(), counts[0], counts[1], counts[2], counts[3], score, level);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of passwords to analyze:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        String[] passwords = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter password " + (i + 1) + ": ");
            passwords[i] = sc.nextLine();
        }
        displayResults(passwords);
        System.out.print("\nDo you want to generate a strong password? (yes/no): ");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter desired password length: ");
            int len = sc.nextInt();
            String strongPwd = generateStrongPassword(len);
            System.out.println("Generated Strong Password: " + strongPwd);
        }
        sc.close();
    }
}

