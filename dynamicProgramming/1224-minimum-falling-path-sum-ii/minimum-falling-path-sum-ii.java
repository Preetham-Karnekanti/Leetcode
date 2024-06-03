class Solution {

    public int minFallingPathSum(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++)
            dp[0][i] = grid[0][i];
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int res = (int) 1e8;
                for (int k = 0; k < grid[0].length; k++) {
                    if (k != j) {
                        res = Math.min(res, grid[i][j] + dp[i - 1][k]);
                    }
                }
                dp[i][j] = res;
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            min = Math.min(dp[grid.length - 1][i], min);
        }
        return min;
    }

    // public int helper(int grid[][], int i, int j) {
    // if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
    // return 0;
    // if (i == grid.length - 1)
    // return grid[i][j];
    // if (dp[i][j] != null)
    // return dp[i][j];
    // int res = (int) 1e8;
    // for (int k = 0; k < grid[0].length; k++) {
    // if (k != j) {
    // res = Math.min(res, grid[i][j] + helper(grid, i + 1, k));
    // }
    // }
    // return dp[i][j] = res;
    // }
}