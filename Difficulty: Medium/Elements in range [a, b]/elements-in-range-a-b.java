import java.util.*;

class Solution {

    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {

        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Process each query using binary search
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            int left = lowerBound(arr, a);
            int right = upperBound(arr, b);

            result.add(right - left);
        }

        return result;
    }

    // Finds first index where value >= key
    private int lowerBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    // Finds first index where value > key
    private int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= key)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
