import java.util.*;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = 0;
                stack.push(i);
                continue;
            }
            if (temperatures[stack.peek()] > temperatures[i]) {
                ans[i] = stack.peek() - i;
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
                stack.push(i);
            } else {
                ans[i] = 0;
                stack.push(i);
            }
        }

        return ans;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = temperatures.length - 1; i >= 0; --i) {
            int currTemperature = temperatures[i];

            while (!stack.isEmpty() && currTemperature >= temperatures[stack.peekLast()]) {
                stack.pollLast();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peekLast() - i;
            }

            stack.offerLast(i);
        }

        return result;
    }

    public int[] dailyTemperatures3(int[] temps) {
        int[] results = new int[temps.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peekLast()] < temps[i]) {
                results[stack.peekLast()] = i - stack.pollLast();
            }
            stack.offerLast(i);
        }

        return results;
    }

    public int[] dailyTemperatures4(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = 0;
                stack.offerLast(i);
                continue;
            }
            if (temperatures[stack.peekLast()] > temperatures[i]) {
                ans[i] = stack.peekLast() - i;
                stack.offerLast(i);
                continue;
            }

            while (!stack.isEmpty() && temperatures[stack.peekLast()] <= temperatures[i]) {
                stack.pollLast();
            }
            if (!stack.isEmpty())
                ans[i] = stack.peekLast() - i;
            else
                ans[i] = 0;

            stack.offerLast(i);
        }

        return ans;
    }
}
