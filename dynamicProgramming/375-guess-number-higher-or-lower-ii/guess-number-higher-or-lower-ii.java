class Solution {
    int[][] dp;

    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        for (var i : dp) {
            Arrays.fill(i, -1);
        }
        return helper(1, n);
    }

    public int helper(int start, int end) {
        if (start >= end)
            return 0;
        if (dp[start][end] != -1)
            return dp[start][end];
        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, i + (Math.max(helper(start, i - 1), helper(i + 1, end))));
        }
        return dp[start][end] = ans;
    }
}