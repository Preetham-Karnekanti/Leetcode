class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(prices, 0, 1, dp);
    }

    public int helper(int prices[], int idx, int shouldBuy, int[][] dp) {
        if (idx == prices.length)
            return 0;
        if (dp[idx][shouldBuy] != -1)
            return dp[idx][shouldBuy];
        if (shouldBuy == 1) {
            int buy = -prices[idx] + helper(prices, idx + 1, 0, dp);
            int skip = helper(prices, idx + 1, 1, dp);
            return dp[idx][shouldBuy] = Math.max(buy, skip);
        } else {
            int sell = prices[idx] + helper(prices, idx + 1, 1, dp);
            int skip = helper(prices, idx + 1, 0, dp);
            return dp[idx][shouldBuy] = Math.max(sell, skip);
        }
    }
}