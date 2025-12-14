import java.util.*;

class Solution {

    // GFG EXPECTS THIS METHOD NAME
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] prefix = new int[n][m];

        // Build prefix sum matrix
        prefix[0][0] = mat[0][0];

        for (int j = 1; j < m; j++) {
            prefix[0][j] = prefix[0][j - 1] + mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            prefix[i][0] = prefix[i - 1][0] + mat[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prefix[i][j] = mat[i][j]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        // Answer queries
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int r1 = q[0];
            int c1 = q[1];
            int r2 = q[2];
            int c2 = q[3];

            int sum = prefix[r2][c2];

            if (r1 > 0) sum -= prefix[r1 - 1][c2];
            if (c1 > 0) sum -= prefix[r2][c1 - 1];
            if (r1 > 0 && c1 > 0) sum += prefix[r1 - 1][c1 - 1];

            result.add(sum);
        }

        return result;
    }
}
