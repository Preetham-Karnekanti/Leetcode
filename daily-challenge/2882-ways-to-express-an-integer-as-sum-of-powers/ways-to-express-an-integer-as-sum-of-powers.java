class Solution {
    int m = (int) 1e9 + 7;
    int dp[][];

    public int numberOfWays(int n, int x) {
        dp = new int[n + 1][n + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(n, x, n);
    }

    public int helper(int n, int x, int i) {
        if (n == 0)
            return 1;
        if (n < 0 || i <= 0)
            return 0;
        if (dp[n][i] != -1)
            return dp[n][i];
        int take = helper(n - (int) Math.pow(i, x), x, i - 1);
        int skip = helper(n, x, i - 1);
        return dp[n][i] = (take + skip) % m;
    }
}