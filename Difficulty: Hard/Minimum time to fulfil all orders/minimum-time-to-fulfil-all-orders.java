class Solution {

    public static int minTime(int[] rank, int n) {
        int low = 0;
        int high = 0;

        // Upper bound
        for (int r : rank) {
            high = Math.max(high, r * n * (n + 1) / 2);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(rank, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] rank, int n, int time) {
        int donuts = 0;

        for (int r : rank) {
            int currTime = 0;
            int k = 1;

            while (true) {
                currTime += r * k;
                if (currTime > time)
                    break;
                donuts++;
                k++;

                if (donuts >= n)
                    return true;
            }
        }
        return false;
    }
}
