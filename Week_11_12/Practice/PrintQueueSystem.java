package Week_11_12.Practice;
import java.util.*;
public class PrintQueueSystem {
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Command (ADD <doc>/PRINT/EXIT): ");
            String cmd = sc.next();
            if (cmd.equalsIgnoreCase("ADD")) {
                String doc = sc.next();
                printQueue.add(doc);
                System.out.println("Added: " + doc);
            } else if (cmd.equalsIgnoreCase("PRINT")) {
                if (!printQueue.isEmpty()) {
                    String doc = printQueue.poll();
                    System.out.println("Printing " + doc);
                } else {
                    System.out.println("No jobs left!");
                }
            } else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting print queue system.");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        sc.close();
    }
}
