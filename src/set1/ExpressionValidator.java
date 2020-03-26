package set1;

import java.util.Stack;

public class ExpressionValidator {

    public static void main(String[] args) {
        String expression = "[{()}]{}(";
        boolean balanced = isBalanced(expression);
        System.out.println("Expression: " + expression + " is " + (balanced ? "" : "NOT") + " balanced");
    }

    public static boolean isBalanced(String expression) {
        // Check for empty string
        if (expression == null || expression.isEmpty()) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            // Push every occurrence opening separator to stack
            if (currentChar == '{' || currentChar == '[' || currentChar == '(') {
                stack.push(currentChar);
                continue;
            }

            // For each closing separator pop out top opening separator
            // Check if they are same type
            char topChar = stack.pop();
            if ((topChar == '{' && currentChar == '}') || (topChar == '[' && currentChar == ']') || (topChar == '(' && currentChar == ')')) {
                continue;
            } else {
                return false;
            }
        }

        // If stack will be empty for balanced expression
        return stack.isEmpty();
    }

}
