class Solution {
    int dp[][][];

    public int maxProfit(int k, int[] prices) {
        dp = new int[prices.length][k + 1][2];
        for (int[][] i : dp) {
            for (int j[] : i)
                Arrays.fill(j, -1);
        }
        return helper(0, k, 1, prices);
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