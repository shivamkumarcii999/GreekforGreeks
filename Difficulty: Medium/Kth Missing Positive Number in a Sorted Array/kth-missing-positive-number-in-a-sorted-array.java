class Solution {
    public int kthMissing(int[] arr, int k) {
        int missingCount = 0;
        int current = 1;
        int index = 0;

        while (true) {
            if (index < arr.length && arr[index] == current) {
                index++;
            } else {
                missingCount++;
                if (missingCount == k) {
                    return current;
                }
            }
            current++;
        }
    }
}
