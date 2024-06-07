class Solution {
    int dx[] = new int[] { -1, 1, 0, 0 };
    int dy[] = new int[] { 0, 0, -1, 1 };

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean vis[][] = new boolean[rows][cols];
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O' && !vis[i][0])
                dfs(board, i, 0, vis);
            if (board[i][cols - 1] == 'O' && !vis[i][cols - 1])
                dfs(board, i, cols - 1, vis);
        }
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O' && !vis[0][i])
                dfs(board, 0, i, vis);
            if (board[rows - 1][i] == 'O' && !vis[rows - 1][i])
                dfs(board, rows - 1, i, vis);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!vis[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    public void dfs(char board[][], int i, int j, boolean vis[][]) {
        if (!isValid(i, j, board) || board[i][j] == 'X' || vis[i][j])
            return;
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            dfs(board, i + dx[k], j + dy[k], vis);
        }
    }

    public boolean isValid(int i, int j, char board[][]) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;
        return true;
    }
}