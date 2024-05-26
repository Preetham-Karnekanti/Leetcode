class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int prev[] = new int[2];
        int prev2[] = new int[2];
        for (int idx = n - 1; idx >= 0; idx--) {
            int cur[] = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int b = -prices[idx] + prev[0];
                    int skip = prev[1];
                    cur[buy] = Math.max(b, skip);
                } else {
                    int sell = prices[idx] + prev2[1];
                    int skip = prev[0];
                    cur[buy] = Math.max(sell, skip);
                }
            }
            prev2 = prev;
            prev = cur;
        }
        return prev[1];
    }

    // public int helper(int idx, int buy, int prices[]) {
    // if (idx >= prices.length)
    // return 0;
    // if (dp[idx][buy] != -1)
    // return dp[idx][buy];
    // if (buy == 1) {
    // int b = -prices[idx] + helper(idx + 1, 0, prices);
    // int skip = helper(idx + 1, 1, prices);
    // return dp[idx][buy] = Math.max(b, skip);
    // } else {
    // int sell = prices[idx] + helper(idx + 2, 1, prices);
    // int skip = helper(idx + 1, 0, prices);
    // return dp[idx][buy] = Math.max(sell, skip);
    // }
    // }
}