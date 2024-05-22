class Solution {
    int dp[][];

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            Arrays.fill(dp[i], -1);
        return helper(grid, 0, 0);
    }

    public int helper(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int right = (int) 1e7;
        int down = (int) 1e7;
        if (i + 1 <= grid.length - 1)
            right = helper(grid, i + 1, j);
        if (j + 1 <= grid[0].length - 1)
            down = helper(grid, i, j + 1);
        return dp[i][j] = Math.min(right, down) + grid[i][j];
    }
}