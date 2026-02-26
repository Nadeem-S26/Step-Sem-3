package Week_1.Lab;

import java.util.Scanner;
class WordLengthTable {
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
    // b. Method to split text into words using charAt()
    public static String[] splitWords(String text) {
        int len = getLength(text);
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int[] spaceIndxs = new int[spaceCount + 2];
        spaceIndxs[0] = -1;
        int idx = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndxs[idx++] = i;
            }
        }
        spaceIndxs[idx] = len;
        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            String word = "";
            for (int j = spaceIndxs[i] + 1; j < spaceIndxs[i + 1]; j++) {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] words = splitWords(input);
        String[][] table = getWordLengthTable(words);
        System.out.println("\nWord\tLength");
        System.out.println("---------------");
        for (int i = 0; i < table.length; i++) {
            String word = table[i][0];
            int length = Integer.parseInt(table[i][1]); 
            System.out.println(word + "\t" + length);
        }
        sc.close();
    }
}