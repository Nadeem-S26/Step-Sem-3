package Week_11_12.Practice;
import java.util.*;
public class CustomerServiceCounter {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Command (ARRIVE <name>/SERVE/STATUS/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("ARRIVE")) {
                String name = sc.next();
                queue.add(name);
                System.out.println(name + " has arrived.");
            } else if (cmd.equalsIgnoreCase("SERVE")) {
                if (!queue.isEmpty()) {
                    String served = queue.poll();
                    System.out.println("Serving " + served);
                } else {
                    System.out.println("No customers to serve.");
                }
            } else if (cmd.equalsIgnoreCase("STATUS")) {
                if (queue.isEmpty()) {
                    System.out.println("No customers waiting.");
                } else {
                    System.out.println("Waiting: " + queue);
                }
            } else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Closing counter.");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        sc.close();
    }
}