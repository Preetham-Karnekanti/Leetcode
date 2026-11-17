
class Solution {

    private static final int MOD = 1_000_000_007;

    private static final int ENTERED_FROM_LEFT = 0;
    private static final int ENTERED_FROM_TOP = 1;

    private int rows;
    private int cols;

    public int uniquePaths(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int[][][] memo = new int[rows][cols][2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return countPaths(grid, 0, 0, ENTERED_FROM_LEFT, memo);
    }

    private int countPaths(int[][] grid, int row, int col,
                           int incomingDirection, int[][][] memo) {

        if (row >= rows || col >= cols) {
            return 0;
        }

        if (row == rows - 1 && col == cols - 1) {
            return 1;
        }

        if (memo[row][col][incomingDirection] != -1) {
            return memo[row][col][incomingDirection];
        }

        int totalPaths = 0;

        if (grid[row][col] == 1) {

            if (incomingDirection == ENTERED_FROM_LEFT) {
                totalPaths = countPaths(
                    grid, row + 1, col, ENTERED_FROM_TOP, memo
                );
            } else {
                totalPaths = countPaths(
                    grid, row, col + 1, ENTERED_FROM_LEFT, memo
                );
            }

        } else {

            totalPaths = (totalPaths + countPaths(
                grid, row, col + 1, ENTERED_FROM_LEFT, memo
            )) % MOD;

            totalPaths = (totalPaths + countPaths(
                grid, row + 1, col, ENTERED_FROM_TOP, memo
            )) % MOD;
        }

        return memo[row][col][incomingDirection] = totalPaths;
    }
}
