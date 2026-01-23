import java.util.*;

class Solution {
    public int maxPeople(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        
        int[] L = new int[n]; // Nearest index on left where arr[L] >= arr[i]
        int[] R = new int[n]; // Nearest index on right where arr[R] >= arr[i]
        Stack<Integer> stack = new Stack<>();
        
        // Find nearest blocking person on the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            L[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        // Find nearest blocking person on the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            R[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        int maxSeen = 0;
        for (int i = 0; i < n; i++) {
            // Visibility = (RightBound - LeftBound - 1)
            int currentVisibility = R[i] - L[i] - 1;
            maxSeen = Math.max(maxSeen, currentVisibility);
        }
        
        return maxSeen;
    }
}