class Solution {
    // int dp[][];

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        // dp = new int[prices.length + 1][2];
        int prev[] = new int[2];
        for (int idx = n - 1; idx >= 0; idx--) {
            int cur[] = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int b = prev[0] - prices[idx];
                    int s = prev[1];
                    cur[buy] = Math.max(b, s);
                } else {
                    int sell = prev[1] + prices[idx];
                    int s = prev[0];
                    cur[buy] = Math.max(sell, s);
                }
            }
            prev = cur;
        }
        return prev[1];
    }

    // public int helper(int[] prices, int idx, int buy) {
    //     if (idx == prices.length)
    //         return 0;
    //     if (dp[idx][buy] != -1)
    //         return dp[idx][buy];
    //     if (buy == 1) {
    //         int b = helper(prices, idx + 1, 0) - prices[idx];
    //         int s = helper(prices, idx + 1, 1);
    //         return dp[idx][buy] = Math.max(b, s);
    //     } else {
    //         int sell = helper(prices, idx + 1, 1) + prices[idx];
    //         int s = helper(prices, idx + 1, 0);
    //         return dp[idx][buy] = Math.max(sell, s);
    //     }
    // }
}