class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j))
                    count++;
            }
        }
        return count;
    }

    public boolean isMagicSquare(int grid[][], int row, int col) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (grid[i][j] >= 10)
                    return false;
                hs.add(grid[i][j]);
            }
        }
        if (hs.size() < 9)
            return false;
        int i = row, j = col;
        // row - wise sum
        int sum1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];

        int sum2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];

        int sum3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];

        if (!(sum1 == 15 && 15 == sum3 && 15 == sum2))
            return false;

        int sum4 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];

        int sum5 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];

        int sum6 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
        if (!(sum4 == 15 && 15 == sum5 && 15 == sum6))
            return false;

        // diagonals

        int sum7 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        j = j + 2;
        int sum8 = grid[i][j] + grid[i + 1][j - 1] + grid[i + 2][j - 2];
        return sum7 == 15 && sum8 == 15;
    }
}