import java.util.*;

class Solution {

    public ArrayList<int[]> mergeOverlap(int[][] arr) {

        ArrayList<int[]> result = new ArrayList<>();

        if (arr == null || arr.length == 0)
            return result;

        // Step 1: Sort intervals by start time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int start = arr[0][0];
        int end = arr[0][1];

        // Step 2: Merge intervals
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= end) {
                // Overlapping interval
                end = Math.max(end, arr[i][1]);
            } else {
                // Non-overlapping interval
                result.add(new int[]{start, end});
                start = arr[i][0];
                end = arr[i][1];
            }
        }

        // Add last interval
        result.add(new int[]{start, end});

        return result;
    }
}
