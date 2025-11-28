import java.util.*;

public class Solution {
    // note: method name exactly "subsetXOR" to match your call
    public List<Integer> subsetXOR(int n) {
        // Compute XOR of 1..n
        int totalXor = 0;
        for (int i = 1; i <= n; i++) totalXor ^= i;

        // If equal to n, take all numbers
        if (totalXor == n) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= n; i++) ans.add(i);
            return ans;
        }

        // remove x such that totalXor ^ x == n  -> x = totalXor ^ n
        int x = totalXor ^ n;

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != x) ans.add(i);
        }
        return ans;
    }

    // example driver
    public static void main(String[] args) {
        Solution obj = new Solution();
        int n = 3;                      // change test value
        List<Integer> res = obj.subsetXOR(n);  // now matches method name exactly
        System.out.println(res);
    }
}
