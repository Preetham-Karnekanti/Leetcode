class Solution {
    public int minFallingPathSum(int[][] grid) {
        int rows, cols = grid.length;
        rows = cols;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            ans = Math.min(ans, solve(grid, 0, i, dp));
        }
        return ans;
    }

    public int solve(int[][] grid, int row, int col, int[][] dp) {
        if (col < 0 || col >= grid.length)
            return 0;
        if (row == grid.length - 1)
            return grid[row][col];
        if (dp[row][col] != -1)
            return dp[row][col];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            if (i == col)
                continue;
            ans = Math.min(ans, grid[row][col] + solve(grid, row + 1, i, dp));
        }
        return dp[row][col] = ans;
    }
}