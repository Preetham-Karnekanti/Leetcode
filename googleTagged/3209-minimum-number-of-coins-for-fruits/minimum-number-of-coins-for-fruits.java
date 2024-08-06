class Solution {
    public int minimumCoins(int[] prices) {
        int dp[] = new int[prices.length];
        Arrays.fill(dp, -1);
        return helper(prices, 0, dp);
    }

    public int helper(int[] prices, int idx, int[] dp) {
        if (idx >= prices.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int maxIdx = 2 * idx + 2;
        int ans = (int) 1e9;
        for (int i = idx + 1; i <= Math.min(prices.length, maxIdx); i++) {
            ans = Math.min(ans, prices[idx] + helper(prices, i, dp));
        }
        return dp[idx] = ans;
    }
}