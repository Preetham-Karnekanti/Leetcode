class Solution {

    public int maxProfit(int k1, int[] prices) {
        int prev[][] = new int[k1 + 1][2];
        for (int idx = prices.length - 1; idx >= 0; idx--) {
            int cur[][] = new int[k1 + 1][2];
            for (int k = 1; k <= k1; k++) {
                for (int buy = 0; buy <= 1; buy++) {
                    if (buy == 1) {
                        int b = -prices[idx] + prev[k][0];
                        int skip = prev[k][1];
                        cur[k][buy] = Math.max(b, skip);
                    } else {
                        int s = prices[idx] + prev[k - 1][1];
                        int skip = prev[k][0];
                        cur[k][buy] = Math.max(s, skip);
                    }
                }
            }
            prev = cur;
        }
        return prev[k1][1];
    }

    // public int helper(int idx, int k, int buy, int[] prices) {
    // if (idx == prices.length || k == 0)
    // return 0;
    // if (dp[idx][k][buy] != -1)
    // return dp[idx][k][buy];
    // if (buy == 1) {
    // int b = -prices[idx] + helper(idx + 1, k, 0, prices);
    // int skip = helper(idx + 1, k, 1, prices);
    // return dp[idx][k][buy] = Math.max(b, skip);
    // } else {
    // int s = prices[idx] + helper(idx + 1, k - 1, 1, prices);
    // int skip = helper(idx + 1, k, 0, prices);
    // return dp[idx][k][buy] = Math.max(s, skip);
    // }
    // }
}