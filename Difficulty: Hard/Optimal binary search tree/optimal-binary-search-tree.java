class Solution {
    // instance method expected by your main: minCost(keys, freq)
    public int minCost(int[] keys, int[] freq) {
        int n = keys.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][n];
        int[][] sum = new int[n][n];

        // Precompute frequency sums
        for (int i = 0; i < n; i++) {
            sum[i][i] = freq[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + freq[j];
            }
        }

        // Base case: single key cost = freq
        for (int i = 0; i < n; i++) dp[i][i] = freq[i];

        // L is chain length
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // try each key r as root for keys[i..j]
                for (int r = i; r <= j; r++) {
                    int left = (r > i) ? dp[i][r - 1] : 0;
                    int right = (r < j) ? dp[r + 1][j] : 0;
                    int cost = left + right + sum[i][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }

    // example main demonstrating usage (you can adapt as needed)
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] keys = {10, 12};
        int[] freq = {34, 50};
        System.out.println(obj.minCost(keys, freq)); // prints 118
    }
}
