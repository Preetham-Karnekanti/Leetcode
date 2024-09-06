class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer dp[][][] = new Integer[prices.length][k + 1][2];
        return helper(prices, 0, k, 1, dp);
    }

    public int helper(int[] prices, int idx, int k, int shouldBuy, Integer dp[][][]) {
        if (idx == prices.length || k == 0)
            return 0;
        if (dp[idx][k][shouldBuy] != null)
            return dp[idx][k][shouldBuy];
        if (shouldBuy == 1) {
            int buy = -prices[idx] + helper(prices, idx + 1, k, 0, dp);
            int skip = helper(prices, idx + 1, k, 1, dp);
            return dp[idx][k][shouldBuy] = Math.max(buy, skip);
        } else {
            int sell = prices[idx] + helper(prices, idx + 1, k - 1, 1, dp);
            int skip = helper(prices, idx + 1, k, 0, dp);
            return dp[idx][k][shouldBuy] = Math.max(sell, skip);
        }
    }
}