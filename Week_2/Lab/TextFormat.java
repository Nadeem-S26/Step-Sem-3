package Week_2.Lab;
import java.util.Scanner;
public class TextFormat {
    public static String[] extractWords(String text) {
        int len = text.length();
        String[] words = new String[1000];
        int count = 0;
        int start = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || text.charAt(i) == ' ') {
                if (start < i) {
                    words[count++] = text.substring(start, i);
                }
                start = i + 1;
            }
        }
        String[] result = new String[count];
        System.arraycopy(words, 0, result, 0, count);
        return result;
    }
    public static String justifyText(String[] words, int width) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLen + 1 + words[j].length() <= width) {
                lineLen += 1 + words[j].length();
                j++;
            }
            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();
            if (gaps == 0 || j == words.length) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < width) line.append(" ");
            } else {
                int totalSpaces = width - (lineLen - gaps);
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        for (int s = 0; s < spacePerGap; s++) line.append(" ");
                        if (extraSpaces-- > 0) line.append(" ");
                    }
                }
            }
            result.append(line).append("\n");
            i = j;
        }
        return result.toString();
    }
    public static String centerAlignText(String[] words, int width) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLen + 1 + words[j].length() <= width) {
                lineLen += 1 + words[j].length();
                j++;
            }
            StringBuilder line = new StringBuilder();
            for (int k = i; k < j; k++) {
                line.append(words[k]);
                if (k < j - 1) line.append(" ");
            }
            int padding = (width - line.length()) / 2;
            StringBuilder centered = new StringBuilder();
            for (int p = 0; p < padding; p++) centered.append(" ");
            centered.append(line);

            result.append(centered).append("\n");
            i = j;
        }
        return result.toString();
    }
    public static String justifyWithConcat(String[] words, int width) {
        String result = "";
        int i = 0;
        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < words.length && lineLen + 1 + words[j].length() <= width) {
                lineLen += 1 + words[j].length();
                j++;
            }
            int gaps = j - i - 1;
            String line = "";
            if (gaps == 0 || j == words.length) {
                for (int k = i; k < j; k++) {
                    line += words[k];
                    if (k < j - 1) line += " ";
                }
                while (line.length() < width) line += " ";
            } else {
                int totalSpaces = width - (lineLen - gaps);
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line += words[k];
                    if (k < j - 1) {
                        for (int s = 0; s < spacePerGap; s++) line += " ";
                        if (extraSpaces-- > 0) line += " ";
                    }
                }
            }
            result += line + "\n";
            i = j;
        }
        return result;
    }
    public static void displayFormattedText(String text, String label) {
        System.out.println("\n" + label + ":");
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.printf("Line %2d (%2d chars): %s\n", i + 1, lines[i].length(), lines[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to format: ");
        String inputText = sc.nextLine();
        System.out.print("Enter desired line width: ");
        int width = sc.nextInt();
        String[] words = extractWords(inputText);
        long startSB = System.nanoTime();
        String justifiedSB = justifyText(words, width);
        long endSB = System.nanoTime();
        long startConcat = System.nanoTime();
        //String justifiedConcat = justifyWithConcat(words, width);
        long endConcat = System.nanoTime();
        String centeredText = centerAlignText(words, width);
        System.out.println("\nOriginal Text:\n" + inputText);
        displayFormattedText(justifiedSB, "Left-Justified Text (StringBuilder)");
        displayFormattedText(centeredText, "Center-Aligned Text");
        System.out.println("\nPerformance Comparison:");
        System.out.printf("StringBuilder Justification Time: %d ns\n", endSB - startSB);
        System.out.printf("String Concatenation Time:       %d ns\n", endConcat - startConcat);
        sc.close();
    }
}
