class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (coins[i] <= j) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(dp[i]));
        return dp[n - 1][amount];
    }
}