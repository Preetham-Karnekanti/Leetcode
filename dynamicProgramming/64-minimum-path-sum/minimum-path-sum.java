class Solution {
    int dp[][];

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else {
                    int up = grid[i][j];
                    int left = grid[i][j];
                    if (i > 0)
                        up += dp[i - 1][j];
                    else
                        up += (int) 1e9;
                    if (j > 0)
                        left += dp[i][j - 1];
                    else
                        left += (int) 1e9;
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}