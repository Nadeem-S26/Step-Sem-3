package Week_2.Assignment;
import java.util.Scanner;
public class FileOrganizer {
    static String[] categories = {"Documents", "Images", "Audio", "Video", "Others"};
    static String[][] extensions = {
        {".txt", ".doc", ".pdf"},
        {".jpg", ".png", ".gif"},
        {".mp3", ".wav"},
        {".mp4", ".avi"},
        {}
    };
    static int[] categoryCounts = new int[categories.length];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of files: ");
        int n = Integer.parseInt(sc.nextLine());
        String[] files = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter file name " + (i + 1) + ": ");
            files[i] = sc.nextLine();
        }
        System.out.println("\nFile Organization Report:");
        System.out.printf("%-20s %-12s %-25s %-15s\n", "Original Name", "Category", "Suggested Name", "Subcategory");
        System.out.println("--------------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            String original = files[i];
            String[] parts = extractFileParts(original);
            String name = parts[0];
            String ext = parts[1];
            String category = categorize(ext);
            String newName = generateNewName(name, ext, category, i + 1);
            String subcategory = simulateContentAnalysis(name, ext);
            System.out.printf("%-20s %-12s %-25s %-15s\n", original, category, newName, subcategory);
        }
        displayCategorySummary();
        generateRenameCommands(files);
        sc.close();
    }
    public static String[] extractFileParts(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot == -1 || dot == filename.length() - 1) {
            return new String[]{filename, ""};
        }
        String name = filename.substring(0, dot).trim();
        String ext = filename.substring(dot).toLowerCase().trim();
        return new String[]{name, ext};
    }
    public static String categorize(String ext) {
        for (int i = 0; i < extensions.length; i++) {
            for (String e : extensions[i]) {
                if (e.equals(ext)) {
                    categoryCounts[i]++;
                    return categories[i];
                }
            }
        }
        categoryCounts[categories.length - 1]++;
        return "Others";
    }
    public static String generateNewName(String name, String ext, String category, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append(category.substring(0, 3).toUpperCase());
        sb.append("_");
        sb.append("2025");
        sb.append("_");
        sb.append(index);
        sb.append(ext);
        return sb.toString();
    }
    public static String simulateContentAnalysis(String name, String ext) {
        if (!ext.equals(".txt")) return "-";
        String lower = name.toLowerCase();
        if (lower.contains("resume")) return "Resume";
        if (lower.contains("report")) return "Report";
        if (lower.contains("code")) return "Code";
        return "General";
    }
    public static void displayCategorySummary() {
        System.out.println("\nCategory Summary:");
        for (int i = 0; i < categories.length; i++) {
            System.out.printf("%-10s : %d files\n", categories[i], categoryCounts[i]);
        }
    }
    public static void generateRenameCommands(String[] files) {
        System.out.println("\nBatch Rename Commands:");
        for (int i = 0; i < files.length; i++) {
            String[] parts = extractFileParts(files[i]);
            String category = categorize(parts[1]);
            String newName = generateNewName(parts[0], parts[1], category, i + 1);
            System.out.println("rename \"" + files[i] + "\" \"" + newName + "\"");
        }
        System.out.println("\nStorage Organization Improvement: Files renamed and categorized successfully.");
    }
}