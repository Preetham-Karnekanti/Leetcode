class Solution {
    int dp[][];

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n][m];
        for (int i = 0; i < m; i++)
            dp[0][i] = matrix[0][i];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int one = (int) 1e9;
                int two = (int) 1e9;
                int three = (int) 1e9;
                one = matrix[i][j] + dp[i - 1][j];
                if (j - 1 >= 0)
                    two = matrix[i][j] + dp[i - 1][j - 1];
                if (j + 1 < m)
                    three = matrix[i][j] + dp[i - 1][j + 1];
                dp[i][j] = Math.min(one, Math.min(two, three));
            }
        }
        for (int i = 0; i < m; i++)
            min = Math.min(min, dp[n - 1][i]);
        return min;
    }

    // public int helper(int[][] grid, int i, int j) {
    // if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
    // return (int) 1e9;
    // if (i == grid.length - 1)
    // return grid[i][j];
    // if (dp[i][j] != Integer.MAX_VALUE)
    // return dp[i][j];
    // int s = grid[i][j] + helper(grid, i + 1, j);
    // int ld = grid[i][j] + helper(grid, i + 1, j - 1);
    // int rd = grid[i][j] + helper(grid, i + 1, j + 1);
    // return dp[i][j] = Math.min(s, Math.min(ld, rd));
    // }
}