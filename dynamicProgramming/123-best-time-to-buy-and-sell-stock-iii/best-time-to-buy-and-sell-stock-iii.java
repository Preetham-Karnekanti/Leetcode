class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int prev[][] = new int[2][3];
        for (int idx = n - 1; idx >= 0; idx--) {
            int cur[][] = new int[2][3];
            for (int buy = 0; buy <= 1; buy++) {
                for (int remainingTransactions = 1; remainingTransactions <= 2; remainingTransactions++) {
                    if (buy == 1) {
                        int b = -prices[idx] + prev[0][remainingTransactions];
                        int skip = prev[1][remainingTransactions];
                        cur[buy][remainingTransactions] = Math.max(b, skip);
                    } else {
                        int sell = prices[idx] + prev[1][remainingTransactions - 1];
                        int skip = prev[0][remainingTransactions];
                        cur[buy][remainingTransactions] = Math.max(sell, skip);
                    }
                }
            }
            prev = cur;
        }
        return prev[1][2];
    }

    // public int helper(int[] prices, int remainingTransactions, int idx, int buy) {
    //     if (idx == prices.length)
    //         return 0;
    //     if (dp[idx][remainingTransactions][buy] != -1)
    //         return dp[idx][remainingTransactions][buy];
    //     if (buy == 1) {
    //         int b = 0;
    //         if (remainingTransactions > 0)
    //             b = -prices[idx] + helper(prices, remainingTransactions - 1, idx + 1, 0);
    //         int skip = helper(prices, remainingTransactions, idx + 1, 1);
    //         return dp[idx][remainingTransactions][buy] = Math.max(b, skip);
    //     } else {
    //         int sell = prices[idx] + helper(prices, remainingTransactions, idx + 1, 1);
    //         int skip = helper(prices, remainingTransactions, idx + 1, 0);
    //         return dp[idx][remainingTransactions][buy] = Math.max(sell, skip);
    //     }
    // }
}