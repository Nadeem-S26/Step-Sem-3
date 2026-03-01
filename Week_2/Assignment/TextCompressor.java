package Week_2.Assignment;
import java.util.Scanner;
public class TextCompressor {
    public static Object[] countFrequency(String text) {
        char[] chars = new char[128]; 
        int[] freq = new int[128];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = (int) ch;
            if (freq[index] == 0) {
                chars[index] = ch;
            }
            freq[index]++;
        }
        int count = 0;
        for (int f : freq) {
            if (f > 0) count++;
        }
        char[] filteredChars = new char[count];
        int[] filteredFreq = new int[count];
        int idx = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                filteredChars[idx] = chars[i];
                filteredFreq[idx] = freq[i];
                idx++;
            }
        }
        return new Object[]{filteredChars, filteredFreq};
    }
    public static String[][] createCompressionCodes(char[] chars, int[] freq) {
        String[][] map = new String[chars.length][2];
        for (int i = 0; i < chars.length; i++) {
            map[i][0] = String.valueOf(chars[i]);
            map[i][1] = String.valueOf((char) (33 + i)); 
        }
        return map;
    }
    public static String compressText(String text, String[][] map) {
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            String ch = String.valueOf(text.charAt(i));
            for (String[] pair : map) {
                if (pair[0].equals(ch)) {
                    compressed.append(pair[1]);
                    break;
                }
            }
        }
        return compressed.toString();
    }
    public static String decompressText(String compressed, String[][] map) {
        StringBuilder original = new StringBuilder();
        for (int i = 0; i < compressed.length(); i++) {
            String code = String.valueOf(compressed.charAt(i));
            for (String[] pair : map) {
                if (pair[1].equals(code)) {
                    original.append(pair[0]);
                    break;
                }
            }
        }

        return original.toString();
    }

    public static void displayAnalysis(String original, String compressed, String decompressed,
                                       char[] chars, int[] freq, String[][] map) {
        System.out.println("\nCharacter Frequency Table:");
        System.out.printf("%-10s %-10s\n", "Character", "Frequency");
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("%-10s %-10d\n", chars[i], freq[i]);
        }
        System.out.println("\nCompression Mapping:");
        System.out.printf("%-10s %-10s\n", "Original", "Code");
        for (String[] pair : map) {
            System.out.printf("%-10s %-10s\n", pair[0], pair[1]);
        }
        System.out.println("\nOriginal Text: " + original);
        System.out.println("Compressed Text: " + compressed);
        System.out.println("Decompressed Text: " + decompressed);
        double ratio = ((double) compressed.length() / original.length()) * 100;
        System.out.printf("Compression Efficiency: %.2f%%\n", 100 - ratio);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to compress: ");
        String text = sc.nextLine();
        Object[] freqData = countFrequency(text);
        char[] chars = (char[]) freqData[0];
        int[] freq = (int[]) freqData[1];
        String[][] map = createCompressionCodes(chars, freq);
        String compressed = compressText(text, map);
        String decompressed = decompressText(compressed, map);
        displayAnalysis(text, compressed, decompressed, chars, freq, map);
        sc.close();
    }
}