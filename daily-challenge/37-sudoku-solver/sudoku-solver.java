class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    public boolean helper(char board[][]) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (helper(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char board[][], int r, int c, char k) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == k)
                return false;
            if (board[r][i] == k)
                return false;
            if (board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == k)
                return false;
        }
        return true;
    }
}