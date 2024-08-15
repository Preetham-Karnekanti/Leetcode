class Solution {
    public boolean isThereAPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Boolean dp[][][] = new Boolean[n][m][n + m];
        if ((n + m - 1) % 2 == 1)
            return false;
        return helper(grid, 0, 0, 0, dp);
    }

    public boolean helper(int[][] grid, int i, int j, int ones, Boolean dp[][][]) {
        int n = grid.length;
        int m = grid[0].length;
        if (i >= n || j >= m)
            return false;
        ones += grid[i][j] == 1 ? 1 : 0;
        int total = n + m - 1;
        int zeros = total - ones;
        if (dp[i][j][ones] != null)
            return dp[i][j][ones];
        if (i == n - 1 && j == m - 1) {
            return ones == zeros;
        }
        return dp[i][j][ones] = helper(grid, i + 1, j, ones, dp) || helper(grid, i, j + 1, ones, dp);
    }
}