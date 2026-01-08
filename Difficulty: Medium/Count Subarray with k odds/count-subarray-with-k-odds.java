import java.util.*;

class Solution {
    public int countSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // prefix odd count 0 appears once
        map.put(0, 1);

        int oddCount = 0;
        int result = 0;

        for (int num : arr) {
            if (num % 2 != 0) {
                oddCount++;
            }

            if (map.containsKey(oddCount - k)) {
                result += map.get(oddCount - k);
            }

            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }
}
