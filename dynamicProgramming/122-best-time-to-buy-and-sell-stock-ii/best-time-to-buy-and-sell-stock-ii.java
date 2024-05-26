class Solution {
    int dp[][];

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int d[]:dp)
            Arrays.fill(d, -1);
        return helper(prices, 0, 1);
    }

    public int helper(int[] prices, int idx, int buy) {
        if (idx == prices.length)
            return 0;
        if (dp[idx][buy] != -1)
            return dp[idx][buy];
        if (buy == 1) {
            int b = helper(prices, idx + 1, 0) - prices[idx];
            int s = helper(prices, idx + 1, 1);
            return dp[idx][buy] = Math.max(b, s);
        } else {
            int sell = helper(prices, idx + 1, 1) + prices[idx];
            int s = helper(prices, idx + 1, 0);
            return dp[idx][buy] = Math.max(sell, s);
        }
    }
}