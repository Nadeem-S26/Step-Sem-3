package Week_2.Lab;
import java.util.Scanner;
public class SubStringReplace {
    public static int[] findPositions(String text, String toFind) {
        int count = 0;
        int index = text.indexOf(toFind);
        while (index != -1) {
            count++;
            index = text.indexOf(toFind, index + toFind.length());
        }
        int[] positions = new int[count];
        index = text.indexOf(toFind);
        int i = 0;
        while (index != -1) {
            positions[i++] = index;
            index = text.indexOf(toFind, index + toFind.length());
        }
        return positions;
    }
    public static String manualReplace(String text, String toFind, String toReplace) {
        StringBuilder newText = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - toFind.length() && text.substring(i, i + toFind.length()).equals(toFind)) {
                newText.append(toReplace);
                i += toFind.length();
            } else {
                newText.append(text.charAt(i));
                i++;
            }
        }
        return newText.toString();
    }
    public static boolean compareResult(String original, String toFind, String toReplace, String manual) {
        return original.replace(toFind, toReplace).equals(manual);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main text:");
        String text = sc.nextLine();
        System.out.println("Enter the substring to find:");
        String toFind = sc.nextLine();
        System.out.println("Enter the substring to replace with:");
        String toReplace = sc.nextLine();
        int[] positions = findPositions(text, toFind);
        System.out.print("Occurrences found at positions: ");
        for (int pos : positions) {
            System.out.print(pos + " ");
        }
        System.out.println();
        String manualResult = manualReplace(text, toFind, toReplace);
        System.out.println("Manual Replace Result: " + manualResult);
        String builtInResult = text.replace(toFind, toReplace);
        System.out.println("Built-in Replace Result: " + builtInResult);
        boolean match = compareResult(text, toFind, toReplace, manualResult);
        System.out.println("Does manual result match built-in? " + match);
        sc.close();
    }
}

