import java.util.*;

class Solution {

    ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {

        // Preprocess: value -> list of indices
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2];

            if (!map.containsKey(x)) {
                ans.add(0);
                continue;
            }

            ArrayList<Integer> list = map.get(x);

            int left = lowerBound(list, l);
            int right = upperBound(list, r);

            ans.add(right - left);
        }

        return ans;
    }

    // First index >= key
    int lowerBound(ArrayList<Integer> list, int key) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < key)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    // First index > key
    int upperBound(ArrayList<Integer> list, int key) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= key)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
