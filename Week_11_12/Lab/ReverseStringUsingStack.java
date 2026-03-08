package Week_11_12.Lab;

import java.util.*;
public class ReverseStringUsingStack {
    public static String reverse(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String input = sc.nextLine();
        String output = reverse(input);
        System.out.println("Reversed: " + output);
        sc.close();
    }
}
