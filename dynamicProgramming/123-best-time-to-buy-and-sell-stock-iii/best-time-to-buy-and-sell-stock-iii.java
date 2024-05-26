class Solution {
    int dp[][][];

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][3][2];
        for (int i[][] : dp) {
            for (int j[] : i)
                Arrays.fill(j, -1);
        }
        return helper(prices, 2, 0, 1);
    }

    public int helper(int[] prices, int remainingTransactions, int idx, int buy) {
        if (idx == prices.length)
            return 0;
        if (dp[idx][remainingTransactions][buy] != -1)
            return dp[idx][remainingTransactions][buy];
        if (buy == 1) {
            int b = 0;
            if (remainingTransactions > 0)
                b = -prices[idx] + helper(prices, remainingTransactions - 1, idx + 1, 0);
            int skip = helper(prices, remainingTransactions, idx + 1, 1);
            return dp[idx][remainingTransactions][buy] = Math.max(b, skip);
        } else {
            int sell = prices[idx] + helper(prices, remainingTransactions, idx + 1, 1);
            int skip = helper(prices, remainingTransactions, idx + 1, 0);
            return dp[idx][remainingTransactions][buy] = Math.max(sell, skip);
        }
    }
}