class Solution {
    int m = (int) 1e9 + 7;
    int dp[][];

    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(n, k, target);
    }

    public int helper(int n, int k, int target) {
        if (target == 0 && n == 0)
            return 1;
        if (n == 0)
            return 0;
        if (dp[n][target] != -1)
            return dp[n][target];
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            if (i <= target) {
                ans = (ans  + helper(n - 1, k, target - i)) % m;
            }
        }
        return dp[n][target] = ans;
    }
}