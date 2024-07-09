class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        return solve(board, 0, n);
    }

    public int solve(char[][] board, int row, int n) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (canWePlace(board, row, col)) {
                board[row][col] = 'Q';
                count += solve(board, row + 1, n);
                board[row][col] = '.';
            }
        }
        return count;
    }

    public boolean canWePlace(char[][] board, int row, int col) {
        int r = row;
        int c = col;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c--;
        }
        c = col;
        r = row;
        while (r >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r--;
        }
        r = row;
        c = col;
        while (r >= 0 && c < board.length) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c++;
        }
        return true;
    }
}