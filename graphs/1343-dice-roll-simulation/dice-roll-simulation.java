class Solution {
    int mod = (int) 1e9 + 7;
    Integer dp[][][];

    public int dieSimulator(int n, int[] rollMax) {
        dp = new Integer[n + 1][8][20];
        return helper(n, rollMax, -1, 0);
    }

    public int helper(int n, int rollMax[], int prev, int count) {
        if (n == 0)
            return 1;
        if (dp[n][prev + 1][count] != null)
            return dp[n][prev + 1][count];
        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            if (i == prev && count >= rollMax[i - 1])
                continue;
            if (i == prev)
                ans = (ans + helper(n - 1, rollMax, i, count + 1)) % mod;
            else
                ans = (ans + helper(n - 1, rollMax, i, 1)) % mod;
        }
        return dp[n][prev + 1][count] = ans;
    }
}