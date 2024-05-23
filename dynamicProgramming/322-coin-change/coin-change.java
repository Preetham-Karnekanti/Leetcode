class Solution {
    int dp[][];

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++)
            Arrays.fill(dp[i], -1);
        int ans = solve(coins, 0, amount);

        if (ans >= 1e6)
            return -1;
        return ans;
    }

    public int solve(int coins[], int idx, int amount) {
        if (amount == 0)
            return 0;
        if (idx == coins.length)
            return (int) 1e6;
        if (dp[idx][amount] != -1)
            return dp[idx][amount];
        int notTake = 0 + solve(coins, idx + 1, amount);
        int take = (int) 1e6;
        if (coins[idx] <= amount) {
            take = 1 + solve(coins, idx, amount - coins[idx]);
        }
        return dp[idx][amount] = Math.min(notTake, take);
    }
}