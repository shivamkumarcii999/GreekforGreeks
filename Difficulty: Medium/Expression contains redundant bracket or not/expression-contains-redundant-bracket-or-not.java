import java.util.Stack;

class Solution {

    boolean checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')') {
                boolean hasOperator = false;

                // Pop until '('
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }

                // Remove '('
                stack.pop();

                // No operator found → redundant
                if (!hasOperator) {
                    return true;
                }
            } else {
                stack.push(ch);
            }
        }
        return false;
    }
}
