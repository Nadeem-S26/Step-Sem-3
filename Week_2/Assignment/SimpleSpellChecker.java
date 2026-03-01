package Week_2.Assignment;

public class SimpleSpellChecker {
    // Sample dictionary
    static String[] dictionary = {"hello", "world", "java", "program", "code", "check", "distance", "string"};
    public static String[] extractWords(String sentence) {
        String[] words = new String[50];
        int count = 0;
        int start = 0;
        for (int i = 0; i <= sentence.length(); i++) {
            if (i == sentence.length() || sentence.charAt(i) == ' ' || isPunctuation(sentence.charAt(i))) {
                if (start < i) {
                    words[count++] = sentence.substring(start, i);
                }
                start = i + 1;
            }
        }
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = words[i];
        }
        return result;
    }

    public static boolean isPunctuation(char ch) {
        return ch == '.' || ch == ',' || ch == ';' || ch == '!' || ch == '?';
    }
    public static int stringDistance(String a, String b) {
        int lenDiff = Math.abs(a.length() - b.length());
        int minLen = Math.min(a.length(), b.length());
        int diffCount = lenDiff;

        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount;
    }
    public static String getSuggestion(String word) {
        String bestMatch = word;
        int minDistance = Integer.MAX_VALUE;

        for (String dictWord : dictionary) {
            int dist = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
            if (dist < minDistance) {
                minDistance = dist;
                bestMatch = dictWord;
            }
        }

        return (minDistance <= 2) ? bestMatch : "No suggestion";
    }
    public static void displayResults(String[] words) {
        System.out.printf("%-15s %-20s %-10s %-12s\n", "Original", "Suggestion", "Distance", "Status");
        System.out.println("---------------------------------------------------------------");

        for (String word : words) {
            String suggestion = getSuggestion(word);
            int distance = stringDistance(word.toLowerCase(), suggestion.toLowerCase());
            String status = (distance == 0) ? "Correct" : "Misspelled";

            System.out.printf("%-15s %-20s %-10d %-12s\n", word, suggestion, distance, status);
        }
    }
    public static void main(String[] args) {
        String sentence = "Helo wrld! This is a simple spell cheker for Java coders.";
        String[] words = extractWords(sentence);
        displayResults(words);
    }
}