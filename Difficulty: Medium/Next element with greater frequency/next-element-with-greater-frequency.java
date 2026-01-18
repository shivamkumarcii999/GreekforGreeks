import java.util.*;

class Solution {

    // Method expected by GFG driver
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        return nextGreaterFrequency(arr);
    }

    // Actual logic method
    public ArrayList<Integer> nextGreaterFrequency(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                   freq.get(stack.peek()) <= freq.get(arr[i])) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        for (int x : ans) {
            result.add(x);
        }

        return result;
    }
}
