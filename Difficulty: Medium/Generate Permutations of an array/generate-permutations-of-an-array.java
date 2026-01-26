import java.util.*;

class Solution {
    
    public ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] arr, ArrayList<Integer> temp,
                           boolean[] used, ArrayList<ArrayList<Integer>> result) {
        
        if (temp.size() == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            temp.add(arr[i]);

            backtrack(arr, temp, used, result);

            // backtrack
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
