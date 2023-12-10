import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        if (s == null)
            return 0;

        int result = 0;
        int sign = 1;
        int num = 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(sign);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');

            } else if (c == '+' || c == '-') {
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;

            } else if (c == '(') {
                stack.push(sign);

            } else if (c == ')') {
                stack.pop();
            }
        }
        result += sign * num;

        return result;
    }

    public int calculate2(String s) {
        Stack<Integer> stack = new Stack<Integer>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (number != 0)
            result += sign * number;

        return result;
    }
}
