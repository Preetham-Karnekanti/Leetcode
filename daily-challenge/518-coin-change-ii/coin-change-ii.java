class Solution {
    Integer dp[][];

    public int change(int amount, int[] coins) {
        dp = new Integer[amount + 1][coins.length + 1];
        return helper(coins, amount, 0);
    }

    public int helper(int coins[], int amount, int idx) {
        if (amount == 0)
            return 1;
        if (coins.length == idx)
            return 0;
        if (dp[amount][idx] != null)
            return dp[amount][idx];
        int skip = helper(coins, amount, idx + 1);
        int take = 0;
        if (amount >= coins[idx])
            take = helper(coins, amount - coins[idx], idx);
        return dp[amount][idx] = skip + take;
    }
}