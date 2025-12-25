import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int curr = mat[i][j];

                int top = (i > 0) ? mat[i - 1][j] : Integer.MIN_VALUE;
                int bottom = (i < n - 1) ? mat[i + 1][j] : Integer.MIN_VALUE;
                int left = (j > 0) ? mat[i][j - 1] : Integer.MIN_VALUE;
                int right = (j < m - 1) ? mat[i][j + 1] : Integer.MIN_VALUE;

                if (curr >= top && curr >= bottom && curr >= left && curr >= right) {
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }

        // Peak always exists as per problem
        result.add(-1);
        result.add(-1);
        return result;
    }
}
