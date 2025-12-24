class Solution {
    public int countLessEqual(int[] arr, int k) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                count++;
            }
        }

        return count;
    }
}
