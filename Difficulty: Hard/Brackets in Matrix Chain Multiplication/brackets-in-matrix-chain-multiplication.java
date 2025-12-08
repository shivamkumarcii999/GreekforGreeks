class Solution {

    // GFG will call this
    public String matrixChainOrder(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] bracket = new int[n][n];

        // DP to find minimum cost and split points
        for (int len = 2; len < n; len++) {
            for (int i = 1; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                             + arr[i - 1] * arr[k] * arr[j];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        bracket[i][j] = k;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        char[] name = { 'A' };
        buildBracket(sb, bracket, 1, n - 1, name);
        return sb.toString();
    }

    // Helper to reconstruct the optimal parenthesization
    private void buildBracket(StringBuilder sb, int[][] bracket,
                              int i, int j, char[] name) {
        if (i == j) {
            sb.append(name[0]++);
            return;
        }

        sb.append("(");
        buildBracket(sb, bracket, i, bracket[i][j], name);
        buildBracket(sb, bracket, bracket[i][j] + 1, j, name);
        sb.append(")");
    }
}
