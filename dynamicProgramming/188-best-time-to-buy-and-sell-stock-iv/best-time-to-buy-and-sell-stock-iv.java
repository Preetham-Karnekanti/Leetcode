class Solution {
    int dp[][][];

    public int maxProfit(int k1, int[] prices) {
        dp = new int[prices.length + 1][k1 + 1][2];
        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int k = 1; k <= k1; k++) {
                for (int buy = 0; buy <= 1; buy++) {
                    if (buy == 1) {
                        int b = -prices[idx] + dp[idx + 1][k][0];
                        int skip = dp[idx + 1][k][1];
                        dp[idx][k][buy] = Math.max(b, skip);
                    } else {
                        int s = prices[idx] + dp[idx + 1][k - 1][1];
                        int skip = dp[idx + 1][k][0];
                        dp[idx][k][buy] = Math.max(s, skip);
                    }
                }
            }
        }
        return dp[0][k1][1];
    }

    public int helper(int idx, int k, int buy, int[] prices) {
        if (idx == prices.length || k == 0)
            return 0;
        if (dp[idx][k][buy] != -1)
            return dp[idx][k][buy];
        if (buy == 1) {
            int b = -prices[idx] + helper(idx + 1, k, 0, prices);
            int skip = helper(idx + 1, k, 1, prices);
            return dp[idx][k][buy] = Math.max(b, skip);
        } else {
            int s = prices[idx] + helper(idx + 1, k - 1, 1, prices);
            int skip = helper(idx + 1, k, 0, prices);
            return dp[idx][k][buy] = Math.max(s, skip);
        }
    }
}