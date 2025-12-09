import java.util.*;

class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Collect duplicates
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                result.add(key);
            }
        }

        // ✅ DO NOT add -1 (GFG expects 0 if empty)
        Collections.sort(result);
        return result;
    }
}
