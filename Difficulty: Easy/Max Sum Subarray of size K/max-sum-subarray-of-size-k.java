class Solution {
    static int maxSubarraySum(int[] arr, int k) {

        int n = arr.length;
        long windowSum = 0;
        long maxSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // Sliding window
        for (int i = k; i < n; i++) {
            windowSum += arr[i];
            windowSum -= arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (int) maxSum;   // 👈 FIX THAT STOPS THE ERROR
    }
}
