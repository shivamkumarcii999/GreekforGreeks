import java.util.*;

class Solution {
    public int countSubset(int[] arr, int sum) {
        int n = arr.length;
        int mid = n / 2;

        // Generate all possible subset sums for the first half
        Map<Long, Integer> leftSums = new HashMap<>();
        generateSums(arr, 0, mid, 0L, leftSums);

        // Generate all possible subset sums for the second half
        Map<Long, Integer> rightSums = new HashMap<>();
        generateSums(arr, mid, n, 0L, rightSums);

        int totalCount = 0;

        // Compare sums from both halves to find combinations that equal the target 'sum'
        for (Map.Entry<Long, Integer> entry : leftSums.entrySet()) {
            long lSum = entry.getKey();
            int lCount = entry.getValue();
            long target = (long) sum - lSum;

            if (rightSums.containsKey(target)) {
                totalCount += lCount * rightSums.get(target);
            }
        }

        return totalCount;
    }

    private void generateSums(int[] arr, int start, int end, long currentSum, Map<Long, Integer> map) {
        if (start == end) {
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
            return;
        }
        // Decision 1: Include the current element
        generateSums(arr, start + 1, end, currentSum + arr[start], map);
        // Decision 2: Exclude the current element
        generateSums(arr, start + 1, end, currentSum, map);
    }
}