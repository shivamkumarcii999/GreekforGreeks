import java.util.*;

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = arr.length;

        // First window
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());

        // Sliding window
        for (int i = k; i < n; i++) {
            // Remove outgoing element
            int out = arr[i - k];
            map.put(out, map.get(out) - 1);
            if (map.get(out) == 0) {
                map.remove(out);
            }

            // Add incoming element
            int in = arr[i];
            map.put(in, map.getOrDefault(in, 0) + 1);

            result.add(map.size());
        }

        return result;
    }
}
