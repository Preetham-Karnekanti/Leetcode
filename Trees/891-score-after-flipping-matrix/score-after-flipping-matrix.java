class Solution {
    public int matrixScore(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) {
                flipRow(i, grid);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (countOne(j, grid) <= rows / 2)
                flipCol(j, grid);
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            count += convertToDecimal(grid[i]);
        }
        return count;
    }

    public void flipRow(int row, int[][] grid) {
        int cols = grid[0].length;
        for (int i = 0; i < cols; i++) {
            grid[row][i] = 1 - grid[row][i];
        }
    }

    public void flipCol(int col, int[][] grid) {
        int rows = grid.length;
        for (int i = 0; i < rows; i++) {
            grid[i][col] = 1 - grid[i][col];
        }
    }

    public int convertToDecimal(int[] row) {
        int pow = 1;
        int number = 0;
        for (int i = row.length - 1; i >= 0; i--) {
            number = number + row[i] * pow;
            pow *= 2;
        }
        return number;
    }

    public int countOne(int col, int[][] grid) {
        int rows = grid.length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            count += grid[i][col];
        }
        return count;
    }
}