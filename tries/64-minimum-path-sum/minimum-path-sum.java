class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(grid, 0, 0, dp);
    }

    public int helper(int[][] grid, int i, int j, int[][] dp) {
        if (i >= grid.length || j >= grid[0].length)
            return (int) 1e7;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = grid[i][j] + Math.min(helper(grid, i + 1, j, dp), helper(grid, i, j + 1, dp));
    }
}