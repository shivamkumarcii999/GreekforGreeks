class Solution {

    // Method name EXACTLY as called by driver code
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;

        // XOR of first window
        int windowXor = 0;
        for (int i = 0; i < k; i++) {
            windowXor ^= arr[i];
        }

        int maxXor = windowXor;

        // Sliding window
        for (int i = k; i < n; i++) {
            windowXor ^= arr[i - k]; // remove old element
            windowXor ^= arr[i];     // add new element

            maxXor = Math.max(maxXor, windowXor);
        }

        return maxXor;
    }
}
