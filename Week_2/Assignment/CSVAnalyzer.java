package Week_2.Assignment;
import java.util.Scanner;
public class CSVAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows (including header): ");
        int numRows = Integer.parseInt(sc.nextLine());
        StringBuilder inputBuilder = new StringBuilder();
        System.out.println("Enter CSV-like data line by line:");
        for (int i = 0; i < numRows; i++) {
            String line = sc.nextLine();
            inputBuilder.append(line).append("\n");
        }
        String csvData = inputBuilder.toString();
        String[][] table = parseCSV(csvData);
        analyzeAndDisplay(table);
        sc.close();
    }
    public static String[][] parseCSV(String text) {
        String[][] result = new String[50][10]; 
        int row = 0, col = 0, i = 0, start = 0;
        boolean insideQuotes = false;
        while (i <= text.length()) {
            char current = (i < text.length()) ? text.charAt(i) : '\n';
            if (current == '"') {
                insideQuotes = !insideQuotes;
            }
            if ((current == ',' && !insideQuotes) || current == '\n' || i == text.length()) {
                String field = text.substring(start, i).trim();
                if (field.startsWith("\"") && field.endsWith("\"")) {
                    field = field.substring(1, field.length() - 1);
                }
                result[row][col++] = field;
                if (current == '\n') {
                    row++;
                    col = 0;
                }
                start = i + 1;
            }
            i++;
        }
        String[][] trimmed = new String[row][];
        for (int r = 0; r < row; r++) {
            int fieldCount = 0;
            while (fieldCount < result[r].length && result[r][fieldCount] != null) fieldCount++;
            trimmed[r] = new String[fieldCount];
            System.arraycopy(result[r], 0, trimmed[r], 0, fieldCount);
        }
        return trimmed;
    }
    public static boolean isNumeric(String value) {
        if (value == null || value.isEmpty()) return false;
        for (char ch : value.toCharArray()) {
            if (!Character.isDigit(ch) && ch != '.') return false;
        }
        return true;
    }
    public static void analyzeAndDisplay(String[][] data) {
    if (data.length < 2 || data[0].length < 3) {
        System.out.println("Error: Insufficient columns in header or data.");
        return;
    }
    int totalRows = data.length - 1;
    int missingAge = 0, invalidScore = 0;
    double min = Double.MAX_VALUE, max = Double.MIN_VALUE, sum = 0;
    int validScores = 0;
    System.out.println("\nFormatted Table:");
    System.out.println("+--------------+------+--------+");
    System.out.printf("| %-12s | %-4s | %-6s |\n", data[0][0], data[0][1], data[0][2]);
    System.out.println("+--------------+------+--------+");
    for (int i = 1; i < data.length; i++) {
        if (data[i].length < 3) {
            System.out.printf("| %-12s | %-4s | %-6s |\n", "Invalid", "??", "Invalid");
            continue;
        }
        String name = padRight(data[i][0], 12);
        String age = (data[i][1] == null || data[i][1].isEmpty()) ? "??" : data[i][1].trim();
        String score = data[i][2].trim();
        if (data[i][1] == null || data[i][1].isEmpty()) missingAge++;
        if (!isNumeric(score)) {
            invalidScore++;
            score = "Invalid";
        } else {
            double val = Double.parseDouble(score);
            min = Math.min(min, val);
            max = Math.max(max, val);
            sum += val;
            validScores++;
            score = String.format("%.2f", val);
        }
        System.out.printf("| %-12s | %-4s | %-6s |\n", name, age, score);
    }
    System.out.println("+--------------+------+--------+");
    double average = (validScores > 0) ? sum / validScores : 0;
    double completeness = ((totalRows - missingAge - invalidScore) / (double) totalRows) * 100;
    System.out.println("\nData Summary Report:");
    System.out.println("Total Records       : " + totalRows);
    System.out.println("Valid Scores        : " + validScores);
    System.out.printf("Score Range         : %.2f to %.2f\n", min, max);
    System.out.printf("Average Score       : %.2f\n", average);
    System.out.println("Missing Ages        : " + missingAge);
    System.out.println("Invalid Scores      : " + invalidScore);
    System.out.printf("Data Completeness   : %.2f%%\n", completeness);
}

    public static String padRight(String text, int width) {
        if (text.length() >= width) return text;
        StringBuilder sb = new StringBuilder(text);
        while (sb.length() < width) sb.append(" ");
        return sb.toString();
    }
}