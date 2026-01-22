import java.util.*;

class Solution {

    // 🔧 Return type changed to int
    public int subarrayRanges(int[] nums) {
        long sumMax = getSum(nums, true);
        long sumMin = getSum(nums, false);

        // 🔧 explicit cast to int
        return (int)(sumMax - sumMin);
    }

    private long getSum(int[] nums, boolean isMax) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        long res = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() &&
                  (i == n ||
                  (isMax ? nums[stack.peek()] < nums[i]
                         : nums[stack.peek()] > nums[i]))) {

                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long count = (long)(mid - left) * (right - mid);
                res += count * nums[mid];
            }
            stack.push(i);
        }
        return res;
    }
}
