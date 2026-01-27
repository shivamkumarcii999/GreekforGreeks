class Solution {
    
    public boolean isWordExist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
        
        if (idx == word.length()) return true;
        
        // boundary + visited + character check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;
        if (visited[i][j] || board[i][j] != word.charAt(idx))
            return false;
        
        visited[i][j] = true;
        
        // explore 4 directions
        boolean found =
                dfs(board, word, i + 1, j, idx + 1, visited) ||
                dfs(board, word, i - 1, j, idx + 1, visited) ||
                dfs(board, word, i, j + 1, idx + 1, visited) ||
                dfs(board, word, i, j - 1, idx + 1, visited);
        
        visited[i][j] = false; // backtrack
        
        return found;
    }
}
