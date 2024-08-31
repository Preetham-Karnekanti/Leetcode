class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, new boolean[board.length][board[0].length], 0))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char board[][], String word, int r, int c, boolean[][] vis, int idx) {
        if (idx == word.length() - 1)
            return true;
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        vis[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (!isValid(nr, nc, board) || vis[nr][nc] || word.charAt(idx + 1) != board[nr][nc])
                continue;
            if (dfs(board, word, nr, nc, vis, idx + 1))
                return true;
        }
        vis[r][c] = false;
        return false;
    }

    public boolean isValid(int r, int c, char[][] grid) {
        if (r < 0 || c < 0 || c >= grid[0].length || r >= grid.length)
            return false;
        return true;
    }
}