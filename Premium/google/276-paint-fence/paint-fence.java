class Solution {
    public int numWays(int n, int k) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, k, dp);
    }

    public int helper(int n, int k, int dp[]) {
        if (n == 1)
            return k;
        if (n == 2)
            return k * k;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = (k - 1) * (helper(n - 1, k, dp) + helper(n - 2, k, dp));
    }
}