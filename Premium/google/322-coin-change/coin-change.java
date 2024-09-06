class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        int ans = helper(coins, 0, amount, dp);
        return ans == (int) 1e9 ? -1 : ans;
    }

    public int helper(int[] coins, int idx, int amount, int[][] dp) {
        if (amount == 0)
            return 0;
        if (idx == coins.length)
            return (int) 1e9;
        if (dp[idx][amount] != -1)
            return dp[idx][amount];
        int take = (int) 1e9;
        if (coins[idx] <= amount) {
            take = 1 + helper(coins, idx, amount - coins[idx], dp);
        }
        int skip = helper(coins, idx + 1, amount, dp);
        return dp[idx][amount] = Math.min(take, skip);
    }
}