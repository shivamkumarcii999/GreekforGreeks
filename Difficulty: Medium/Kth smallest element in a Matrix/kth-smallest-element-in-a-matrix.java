import java.util.*;

class Solution {
    public static int kthSmallest(int[][] mat, int k) {

        int n = mat.length;

        // Min heap: {value, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Push first element of each row
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{mat[i][0], i, 0});
        }

        int ans = 0;

        while (k-- > 0) {
            int[] cur = pq.poll();
            ans = cur[0];
            int r = cur[1];
            int c = cur[2];

            // Push next element in same row
            if (c + 1 < n) {
                pq.add(new int[]{mat[r][c + 1], r, c + 1});
            }
        }
        return ans;
    }
}
