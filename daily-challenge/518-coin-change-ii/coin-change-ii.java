class Solution {
    int dp[][];

    public int change(int amount, int[] coins) {
        dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < coins.length + 1; i++)
            dp[0][i] = 1;
        int n = coins.length;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int skip = dp[j][i - 1];
                int take = 0;

                if (coins[i - 1] <= j) {
                    take = dp[j - coins[i - 1]][i];
                }

                dp[j][i] = take + skip;
            }
        }

        return dp[amount][n];
    }
}