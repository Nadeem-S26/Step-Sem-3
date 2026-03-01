package Week_2.Practice;
import java.util.Arrays;
import java.util.Scanner;
public class StringManipulation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence with mixed formatting : ");
        String text = sc.nextLine();
        String trim_text = text.trim();
        String replace_text = trim_text.replace(" ", "_");
        String replaceAll_text = trim_text.replaceAll("\\d","");
        String[] words = trim_text.split("\\s+");
        String join_text = String.join("|", words) ;

        System.out.println("Original Input: " + text);
        System.out.println("Trimmed: " + trim_text);
        System.out.println("Spaces Replaced: " + replace_text);
        System.out.println("Digits Removed: " + replaceAll_text);
        System.out.println("Words Array: " + Arrays.toString(words));
        System.out.println("Rejoined with '|': " + join_text);
        String noPunct = removePunctuation(trim_text);
        System.out.println("No Punctuation: " + noPunct);
        String capitalized = capitalizeWords(noPunct);
        System.out.println("Capitalized Words: " + capitalized);
        String reversed = reverseWordOrder(noPunct);
        System.out.println("Reversed Word Order: " + reversed);
        System.out.println("Word Frequency:");
        countWordFrequency(noPunct);
        sc.close();
    } 
    public static String removePunctuation(String s){
        return s.replaceAll("[\\p{Punct}]", "");
    }
    public static String capitalizeWords(String text) {
    String[] words = text.split("\\s+");
    StringBuilder result = new StringBuilder();
    for (String word : words) {
        if (!word.isEmpty()) {
            result.append(Character.toUpperCase(word.charAt(0)))
                  .append(" ");
        }
    }
    return result.toString().trim();
    }
    public static String reverseWordOrder(String text) {
        String[] words = text.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim();
    }
    public static void countWordFrequency(String text) {
        text = text.replaceAll("[\\p{Punct}\\d]", "").toLowerCase().trim();
        String[] words = text.split("\\s+");
        boolean[] visited = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                int count = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                        visited[j] = true;
                    }
                }
                System.out.println(words[i] + ": " + count);
            }
        }
    }

}