package Week_1.Lab;
import java.util.Scanner;
class WordLengthAnalyze { 
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }
    public static String[] splitWords(String text) {
        int len = getLength(text);
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int[] spaceIndx = new int[spaceCount + 2]; 
        spaceIndx[0] = -1;
        int idx = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndx[idx++] = i;
            }
        }
        spaceIndx[idx] = len;
        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            String word = "";
            for (int j = spaceIndx[i] + 1; j < spaceIndx[i + 1]; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }
    public static String[][] getWordLengthTable(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }

        return result;
    }
    public static int[] findShortestAndLongest(String[][] table) {
        int minLength = Integer.parseInt(table[0][1]);
        int maxLength = Integer.parseInt(table[0][1]);
        for (int i = 1; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);
            if (length < minLength) {
                minLength = length;
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return new int[]{minLength, maxLength};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] words = splitWords(input);
        String[][] table = getWordLengthTable(words);
        int[] minMax = findShortestAndLongest(table);
        System.out.println("\nWord\tLength");
        System.out.println("---------------");
        for (int i = 0; i < table.length; i++) {
            String word = table[i][0];
            int length = Integer.parseInt(table[i][1]);
            System.out.println(word + "\t" + length);
        }
        System.out.println("\nShortest word length: " + minMax[0]);
        System.out.println("Longest word length: " + minMax[1]);
        sc.close();
    }
}
