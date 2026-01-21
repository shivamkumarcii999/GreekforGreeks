import java.util.*;

class Solution {
    // Function to calculate the span of stock's price for all n days.
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>();
        // Stack stores indices of the prices
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and 
            // current price is greater than or equal to price at stack top
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            // If stack is empty, then arr[i] is greater than all elements to its left
            if (st.isEmpty()) {
                span.add(i + 1);
            } else {
                // Span is the difference between current index and next greater element index
                span.add(i - st.peek());
            }

            // Push this element's index to stack
            st.push(i);
        }
        return span;
    }
}