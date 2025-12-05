class Solution {
    long minCost(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;

        if (k == 1) {
            if (n == 1) return costs[0][0];
            return -1; // cannot paint adjacent walls with same color
        }

        long[] prev = new long[k];

        // Initialize with first row
        for (int j = 0; j < k; j++) {
            prev[j] = costs[0][j];
        }

        for (int i = 1; i < n; i++) {

            // Find smallest & second smallest in prev[]
            long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
            int idx1 = -1;

            for (int j = 0; j < k; j++) {
                long val = prev[j];
                if (val < min1) {
                    min2 = min1;
                    min1 = val;
                    idx1 = j;
                } else if (val < min2) {
                    min2 = val;
                }
            }

            long[] curr = new long[k];

            // Compute current row dp
            for (int j = 0; j < k; j++) {
                if (j == idx1) {
                    curr[j] = costs[i][j] + min2;  // cannot pick same color
                } else {
                    curr[j] = costs[i][j] + min1;
                }
            }

            prev = curr;
        }

        long ans = Long.MAX_VALUE;
        for (long val : prev) ans = Math.min(ans, val);

        return ans;
    }
}
