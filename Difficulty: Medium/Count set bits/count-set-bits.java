class Solution {
    static int countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            int x = largestPowerOf2(n);
            int bitsUpTo2x = x * (1 << (x - 1));
            int msbBits = n - (1 << x) + 1;

            count += bitsUpTo2x + msbBits;

            n = n - (1 << x);
        }
        return count;
    }

    static int largestPowerOf2(int n) {
        int p = 0;
        while ((1 << (p + 1)) <= n) {
            p++;
        }
        return p;
    }
}
