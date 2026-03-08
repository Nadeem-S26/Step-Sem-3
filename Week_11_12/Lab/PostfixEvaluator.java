package Week_11_12.Lab;
import java.util.*;
public class PostfixEvaluator {
    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.split(" ");
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }
    private static int applyOperator(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; 
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix expression (space-separated): ");
        String input = sc.nextLine();
        int result = evaluatePostfix(input);
        System.out.println("Result: " + result);
        sc.close();
    }
}