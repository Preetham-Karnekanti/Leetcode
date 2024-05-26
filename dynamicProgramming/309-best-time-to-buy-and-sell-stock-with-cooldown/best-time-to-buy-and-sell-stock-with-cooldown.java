class Solution {
    int dp[][];

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[prices.length + 2][2];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int b = -prices[idx] + dp[idx + 1][0];
                    int skip = dp[idx + 1][1];
                    dp[idx][buy] = Math.max(b, skip);
                } else {
                    int sell = prices[idx] + dp[idx + 2][1];
                    int skip = dp[idx + 1][0];
                    dp[idx][buy] = Math.max(sell, skip);
                }
            }
        }
        return dp[0][1];
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