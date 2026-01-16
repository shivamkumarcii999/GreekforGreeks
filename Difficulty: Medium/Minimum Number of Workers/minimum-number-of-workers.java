import java.util.*;

class Solution {

    public int minMen(int[] arr) {
        int n = arr.length;

        List<int[]> intervals = new ArrayList<>();

        // Create intervals
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int left = Math.max(0, i - arr[i]);
                int right = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{left, right});
            }
        }

        // Sort by start asc, end desc
        intervals.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        int count = 0;
        int coveredTill = 0;
        int i = 0;

        // Greedy interval covering
        while (coveredTill < n) {
            int farthest = coveredTill;

            while (i < intervals.size() && intervals.get(i)[0] <= coveredTill) {
                farthest = Math.max(farthest, intervals.get(i)[1] + 1);
                i++;
            }

            if (farthest == coveredTill) {
                return -1; // cannot extend coverage
            }

            count++;
            coveredTill = farthest;
        }

        return count;
    }
}
