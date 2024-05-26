class Solution {
    int dp[][];

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(0, 1, prices);
    }

    public int helper(int idx, int buy, int prices[]) {
        if (idx >= prices.length)
            return 0;
        if (dp[idx][buy] != -1)
            return dp[idx][buy];
        if (buy == 1) {
            int b = -prices[idx] + helper(idx + 1, 0, prices);
            int skip = helper(idx + 1, 1, prices);
            return dp[idx][buy] = Math.max(b, skip);
        } else {
            int sell = prices[idx] + helper(idx + 2, 1, prices);
            int skip = helper(idx + 1, 0, prices);
            return dp[idx][buy] = Math.max(sell, skip);
        }
    }
}