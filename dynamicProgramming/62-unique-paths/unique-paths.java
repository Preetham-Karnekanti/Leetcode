class Solution {

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
        // for (int i = 0; i < m; i++)
        // Arrays.fill(dp[i], -1);

        // return helper(m - 1, n - 1);
    }

    // public int helper(int m, int n) {
    //     if (m < 0 || n < 0)
    //         return 0;
    //     if (m == 0 && n == 0)
    //         return 1;
    //     if (dp[m][n] != -1)
    //         return dp[m][n];
    //     return helper(m - 1, n) + helper(m, n - 1);
    // }
}