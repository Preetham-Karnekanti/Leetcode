class Solution {
    public int twoEggDrop(int n) {
        int dp[][] = new int[n + 1][3];
        return f(n, 2, dp);
    }

    public int f(int n, int e, int dp[][]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (e == 1) {
            return n;
        }
        if (dp[n][e] > 0)
            return dp[n][e];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int willBreak = f(i - 1, e - 1, dp);
            int notBreak = f(n - i, e, dp);
            ans = Math.min(ans, Math.max(willBreak, notBreak));
        }
        return dp[n][e] = ans + 1;
    }
}