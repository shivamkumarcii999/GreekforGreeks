class Solution {

    int rowWithMax1s(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        int maxOnes = 0;
        int rowIndex = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }

            if (count > maxOnes) {
                maxOnes = count;
                rowIndex = i;
            }
        }

        return rowIndex;
    }
}
