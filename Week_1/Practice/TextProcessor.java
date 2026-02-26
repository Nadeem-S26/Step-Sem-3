import java.util.*;

public class TextProcessor {
    // Method to clean and validate input
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " "); // Remove extra spaces
        String[] words = input.split(" ");
        StringBuilder cleaned = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                cleaned.append(Character.toUpperCase(word.charAt(0)))
                       .append(word.substring(1).toLowerCase())
                       .append(" ");
            }
        }
        return cleaned.toString().trim();
    }

    // Method to analyze text
    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int sentenceCount = text.split("[.!?]").length;
        int charCount = text.replaceAll("\\s", "").length();

        String longestWord = "";
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
            for (char c : word.toLowerCase().toCharArray()) {
                charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
            }
        }

        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > maxFreq) {
                mostCommonChar = entry.getKey();
                maxFreq = entry.getValue();
            }
        }

        System.out.println("\n=== TEXT ANALYSIS ===");
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Characters (excluding spaces): " + charCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: '" + mostCommonChar + "' (" + maxFreq + " times)");
    }

    // Method to create word array and sort alphabetically
    public static String[] getWordsSorted(String text) {
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph of text:\n> ");
        String input = sc.nextLine();

        String cleaned = cleanInput(input);
        System.out.println("\nCleaned Text:\n" + cleaned);

        analyzeText(cleaned);

        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println("\n=== SORTED WORDS ===");
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("\nSearch for a word:\n> ");
        String search = sc.nextLine().toLowerCase();
        boolean found = Arrays.asList(sortedWords).contains(search);
        System.out.println(found ? "Word found!" : "Word not found.");

        sc.close();
    }
}

