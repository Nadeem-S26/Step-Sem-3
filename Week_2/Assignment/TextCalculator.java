package Week_2.Assignment;

import java.util.Scanner;
public class TextCalculator {
    public static boolean isValidExpression(String expr) {
        int open = 0, close = 0;
        char prev = ' ';
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (!(Character.isDigit(ch) || "+-*/() ".indexOf(ch) >= 0)) return false;
            if (ch == '(') open++;
            if (ch == ')') close++;
            if ("+-*/".indexOf(ch) >= 0 && "+-*/".indexOf(prev) >= 0) return false;
            if (ch != ' ') prev = ch;
        }
        return open == close;
    }
    public static Object[] parseExpression(String expr) {
        String[] tokens = new String[100];
        int count = 0;
        int i = 0;
        while (i < expr.length()) {
            char ch = expr.charAt(i);
            if (ch == ' ') {
                i++;
                continue;
            }
            if ("+-*/()".indexOf(ch) >= 0) {
                tokens[count++] = String.valueOf(ch);
                i++;
            } else if (Character.isDigit(ch)) {
                int start = i;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    i++;
                }
                tokens[count++] = expr.substring(start, i);
            }
        }
        String[] result = new String[count];
        System.arraycopy(tokens, 0, result, 0, count);
        return result;
    }
    public static int evaluateSimple(String[] tokens, StringBuilder steps) {
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("*") || tokens[i].equals("/")) {
                int left = Integer.parseInt(tokens[i - 1]);
                int right = Integer.parseInt(tokens[i + 1]);
                int result = tokens[i].equals("*") ? left * right : left / right;
                steps.append(left).append(" ").append(tokens[i]).append(" ").append(right)
                     .append(" = ").append(result).append("\n");
                tokens[i - 1] = String.valueOf(result);
                for (int j = i; j < tokens.length - 2; j++) {
                    tokens[j] = tokens[j + 2];
                }
                tokens = java.util.Arrays.copyOf(tokens, tokens.length - 2);
                i = -1; 
            }
        }
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            int next = Integer.parseInt(tokens[i + 1]);
            if (tokens[i].equals("+")) {
                steps.append(result).append(" + ").append(next).append(" = ");
                result += next;
                steps.append(result).append("\n");
            } else {
                steps.append(result).append(" - ").append(next).append(" = ");
                result -= next;
                steps.append(result).append("\n");
            }
        }
        return result;
    }
    public static int evaluateWithParentheses(String expr, StringBuilder steps) {
        while (expr.contains("(")) {
            int start = expr.lastIndexOf("(");
            int end = expr.indexOf(")", start);
            String subExpr = expr.substring(start + 1, end);
            Object[] parsed = parseExpression(subExpr);
            int subResult = evaluateSimple((String[]) parsed, steps);
            expr = expr.substring(0, start) + subResult + expr.substring(end + 1);
            steps.append("Replaced (").append(subExpr).append(") with ").append(subResult).append("\n");
        }
        Object[] finalParsed = parseExpression(expr);
        return evaluateSimple((String[]) finalParsed, steps);
    }
    public static void displayCalculation(String expr) {
        System.out.println("\nExpression: " + expr);
        if (!isValidExpression(expr)) {
            System.out.println("Invalid expression format.");
            return;
        }
        StringBuilder steps = new StringBuilder();
        int result = evaluateWithParentheses(expr, steps);
        System.out.println("Calculation Steps:");
        System.out.println(steps.toString());
        System.out.println("Final Result: " + result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of expressions to evaluate: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter expression " + (i + 1) + ": ");
            String expr = sc.nextLine();
            displayCalculation(expr);
        }
        sc.close();
    }
}
