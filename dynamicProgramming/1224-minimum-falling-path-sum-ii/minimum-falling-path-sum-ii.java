class Solution {
    Integer dp[][];

    public int minFallingPathSum(int[][] grid) {
        int min = Integer.MAX_VALUE;
        dp = new Integer[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            min = Math.min(min, helper(grid, 0, i));
        }
        return min;
    }

    public int helper(int grid[][], int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;
        if (i == grid.length - 1)
            return grid[i][j];
        if (dp[i][j] != null)
            return dp[i][j];
        int res = (int) 1e8;
        for (int k = 0; k < grid[0].length; k++) {
            if (k != j) {
                res = Math.min(res, grid[i][j] + helper(grid, i + 1, k));
            }
        }
        return dp[i][j] = res;
    }
}