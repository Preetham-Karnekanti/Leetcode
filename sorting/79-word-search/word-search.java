class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (solve(board, word, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean solve(char[][] board, String word, int r, int c, int idx) {
        if (!isValid(r, c, board) || board[r][c] == '*')
            return false;
        if (word.charAt(idx) != board[r][c])
            return false;
        if (idx == word.length() - 1)
            return true;
        char ch = board[r][c];
        board[r][c] = '*';
        if (solve(board, word, r + 1, c, idx + 1) ||
                solve(board, word, r - 1, c, idx + 1) ||
                solve(board, word, r, c + 1, idx + 1) ||
                solve(board, word, r, c - 1, idx + 1))
            return true;
        board[r][c] = ch;
        return false;
    }

    public boolean isValid(int r, int c, char board[][]) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return false;
        return true;
    }
}