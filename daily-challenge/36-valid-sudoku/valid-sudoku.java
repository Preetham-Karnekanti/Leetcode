class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (checkRow(board, i) == false) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (checkColumn(board, j) == false) {
                return false;
            }
        }
        int a[] = { 0, 0, 0, 3, 3, 3, 6, 6, 6 };
        int b[] = { 0, 3, 6, 0, 3, 6, 0, 3, 6 };
        for (int i = 0; i < 9; i++) {
            if (checkCell(board, a[i], b[i]) == false)
                return false;
        }
        return true;
    }

    public boolean checkRow(char board[][], int row) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == '.')
                continue;
            if (hs.contains(board[row][i]))
                return false;
            else
                hs.add(board[row][i]);
        }
        return true;
    }

    public boolean checkColumn(char board[][], int column) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == '.')
                continue;
            if (hs.contains(board[i][column]))
                return false;
            else
                hs.add(board[i][column]);
        }

        return true;
    }

    public boolean checkCell(char board[][], int i, int j) {
        HashSet<Character> hs = new HashSet<>();
        int row = i + 3, column = j + 3;
        for (int k = i; k < row; k++) {
            for (int l = j; l < column; l++) {
                if (board[k][l] == '.')
                    continue;
                if (hs.contains(board[k][l]))
                    return false;
                else
                    hs.add(board[k][l]);
            }
        }
        return true;
    }
}
