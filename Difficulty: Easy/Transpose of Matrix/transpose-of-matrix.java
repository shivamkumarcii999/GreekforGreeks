class Solution {
    static ArrayList<ArrayList<Integer>> transpose(int matrix[][]) {
        int n = matrix.length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(matrix[j][i]); // transpose
            }
            ans.add(row);
        }

        return ans;
    }
}
