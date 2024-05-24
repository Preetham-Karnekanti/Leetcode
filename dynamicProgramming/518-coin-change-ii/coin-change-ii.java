class Solution {
    int dp[][];

    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return helper(coins, amount, n - 1);
    }

    public int helper(int[] coins, int amount, int idx) {
        if (amount == 0)
            return 1;
        if (idx < 0)
            return 0;
        if (dp[idx][amount] != -1)
            return dp[idx][amount];
        int notTake = helper(coins, amount, idx - 1);
        int take = 0;
        if (coins[idx] <= amount)
            take = helper(coins, amount - coins[idx], idx);
        return dp[idx][amount] = take + notTake;
    }
}