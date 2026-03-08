package Week_11_12.Assignment;

import java.util.*;

public class TextEditorUndoFeature {
    public static void main(String[] args) {
        Stack<String> actionStack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Command (TYPE <word>/UNDO/SHOW/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("TYPE")) {
                String word = sc.next();
                actionStack.push(word);
                System.out.println("Typed: " + word);
            } else if (cmd.equalsIgnoreCase("UNDO")) {
                if (!actionStack.isEmpty()) {
                    String undone = actionStack.pop();
                    System.out.println("Undone: " + undone);
                } else {
                    System.out.println("Nothing to undo.");
                }
            } else if (cmd.equalsIgnoreCase("SHOW")) {
                if (actionStack.isEmpty()) {
                    System.out.println("Editor is empty.");
                } else {
                    System.out.print("Current Text: ");
                    for (String word : actionStack) {
                        System.out.print(word + " ");
                    }
                    System.out.println();
                }
            } else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting editor.");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        sc.close();
    }
}