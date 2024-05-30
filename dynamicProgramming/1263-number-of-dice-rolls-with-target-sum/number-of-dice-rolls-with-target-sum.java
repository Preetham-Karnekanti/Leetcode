class Solution {
    int m = (int) 1e9 + 7;
    int dp[][];

    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                int ans = 0;
                for (int idx = 1; idx <= k; idx++) {
                    if (idx <= j) {
                        ans = (ans + dp[i - 1][j - idx]) % m;
                    }
                }
                dp[i][j] = ans;
            }
        }
        return dp[n][target];
    }

    public int helper(int n, int k, int target) {
        if (target == 0 && n == 0)
            return 1;
        if (n == 0)
            return 0;
        if (dp[n][target] != -1)
            return dp[n][target];
        int ans = 0;
        for (int idx = 1; idx <= k; idx++) {
            if (idx <= target) {
                ans = (ans + helper(n - 1, k, target - idx)) % m;
            }
        }
        return dp[n][target] = ans;
    }
}