class Solution {
    int dp[][];

    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++)
            Arrays.fill(dp[i], -1);
        return helper(prices, 1, fee, 0);
    }

    public int helper(int[] prices, int shouldBuy, int fee, int ind) {
        if (ind >= prices.length)
            return 0;
        if(dp[ind][shouldBuy] !=-1)
            return dp[ind][shouldBuy];
        int profit = 0;
        if (shouldBuy == 1) {
            int buy = -prices[ind] + helper(prices, 0, fee, ind + 1);
            int skip = helper(prices, 1, fee, ind + 1);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[ind] - fee + helper(prices, 1, fee, ind + 1);
            int skip = helper(prices, 0, fee, ind + 1);
            profit = Math.max(sell, skip);
        }
        return dp[ind][shouldBuy] = profit;
    }
}