class Solution {
    Integer dp[][];

    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length][amount + 1];
        int ans = helper(coins, amount, 0);
        return ans == (int) 1e9 ? -1 : ans;
    }

    public int helper(int coins[], int amount, int idx) {
        if (idx == coins.length)
            return amount == 0 ? 0 : (int) 1e9;
        if (amount < 0)
            return (int) 1e9;
        if (dp[idx][amount] != null)
            return dp[idx][amount];
        int pick = 1 + helper(coins, amount - coins[idx], idx);
        int skip = helper(coins, amount, idx + 1);
        return dp[idx][amount] = Math.min(skip, pick);
    }
}