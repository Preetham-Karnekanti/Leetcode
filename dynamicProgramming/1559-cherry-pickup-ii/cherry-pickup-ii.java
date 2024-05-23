class Solution {
    int dp[][][];

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new int[rows][cols][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(grid, 0, 0, cols - 1);
    }

    public int helper(int[][] grid, int i, int j1, int j2) {
        if (j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length) {
            return (int) -1e5;
        }
        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else
                return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        int max = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (j1 == j2)
                    max = Math.max(max, grid[i][j1] + helper(grid, i + 1, j1 + dx, j2 + dy));
                else
                    max = Math.max(max, grid[i][j1] + grid[i][j2] + helper(grid, i + 1, j1 + dx, j2 + dy));
            }
        }
        return dp[i][j1][j2] = max;
    }
}