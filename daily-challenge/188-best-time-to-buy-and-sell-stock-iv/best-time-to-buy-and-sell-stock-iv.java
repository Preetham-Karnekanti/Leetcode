class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][k + 1][2];
        for (int i[][] : dp) {
            for (int j[] : i)
                Arrays.fill(j, -1);
        }
        return helper(prices, 0, k, 0, dp);
    }

    public int helper(int prices[], int idx, int k, int shouldBuy, int[][][] dp) {
        if (idx == prices.length || k == 0)
            return 0;
        if(dp[idx][k][shouldBuy] != -1)
            return dp[idx][k][shouldBuy];
        if (shouldBuy == 0) {
            int buy = helper(prices, idx + 1, k, 1, dp) - prices[idx];
            int skip = helper(prices, idx + 1, k, 0, dp);
            return dp[idx][k][shouldBuy] = Math.max(buy, skip);
        } else {
            int sell = helper(prices, idx + 1, k - 1, 0, dp) + prices[idx];
            int skip = helper(prices, idx + 1, k, 1, dp);
            return dp[idx][k][shouldBuy] = Math.max(sell, skip);
        }
    }
}