class Solution {
    public int josephus(int n, int k) {
        // 'res' stores the 0-indexed position of the survivor
        int res = 0;
        
        // Iteratively calculate the survivor for each size from 1 to n
        for (int i = 1; i <= n; i++) {
            res = (res + k) % i;
        }
        
        // Add 1 to convert the 0-indexed result back to 1-indexed
        return res + 1;
    }
}