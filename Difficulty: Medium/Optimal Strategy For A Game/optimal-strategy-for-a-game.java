class Solution {
    static int maximumAmount(int[] arr) {
        int n = arr.length;
        long[][] dp = new long[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {

                long x = (i + 2 <= j) ? dp[i + 2][j] : 0;
                long y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                long z = (i <= j - 2) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(
                        arr[i] + Math.min(x, y),
                        arr[j] + Math.min(y, z)
                );
            }
        }
        return (int) dp[0][n - 1];  // ✅ explicit cast to int
    }
}
