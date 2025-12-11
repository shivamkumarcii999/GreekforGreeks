import java.util.*;

public class Solution {
    // Driver expects: ArrayList<Integer> constructArr(int[] arr)
    public ArrayList<Integer> constructArr(int[] arr) {
        ArrayList<Integer> out = new ArrayList<>();
        if (arr == null) return out;
        int m = arr.length;
        if (m == 0) return out;
        if (m == 1) { // any two numbers that sum to arr[0] are valid; choose (0, arr[0])
            out.add(0);
            out.add(arr[0]);
            return out;
        }

        int n = findN(m);
        if (n == -1) return out;

        // need at least 3 sums to uniquely determine first three elements
        if (m < 3) return out;

        // compute res[0] = (arr[0] + arr[1] - arr[n-1]) / 2
        long twoA = (long)arr[0] + arr[1] - arr[n - 1];
        if (twoA % 2 != 0) return out;
        int a0 = (int)(twoA / 2);

        int[] res = new int[n];
        res[0] = a0;
        for (int i = 1; i < n; i++) {
            // arr[i-1] is res[0] + res[i]
            res[i] = arr[i - 1] - res[0];
        }

        // verify pair-sum order matches input arr[]
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (idx >= m || arr[idx] != res[i] + res[j]) return out;
                idx++;
            }
        }

        for (int v : res) out.add(v);
        return out;
    }

    // find n such that n*(n-1)/2 == m, else -1
    private int findN(int m) {
        long D = 1 + 8L * m;
        long s = (long)Math.sqrt(D);
        if (s * s != D) return -1;
        long x = (1 + s) / 2;
        return (x * (x - 1) / 2 == m) ? (int)x : -1;
    }

    // optional main for local testing
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] a = {4,5,3}; // example -> original [3,1,2]
        System.out.println(sol.constructArr(a)); // prints [3,1,2]
    }
}
