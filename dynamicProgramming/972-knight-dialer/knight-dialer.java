class Solution {
    int arr[][] = new int[][] { { 4, 6 }, { 8, 6 }, { 7, 9 }, { 4, 8 }, { 3, 9, 0 }, {}, { 1, 7, 0 }, { 2, 6 },
            { 1, 3 }, { 2, 4 } };
    int mod = 1000000000 + 7;
    Integer dp[][];

    public int knightDialer(int n) {
        dp = new Integer[n + 1][10];
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans = (ans + helper(i, n - 1)) % mod;
        }
        return ans;
    }

    public int helper(int cur, int n) {
        if (n == 0)
            return 1;
        if (dp[n][cur] != null)
            return dp[n][cur];
        int ans = 0;
        for (int i : arr[cur]) {
            ans = (ans + helper(i, n - 1)) % mod;
        }
        return dp[n][cur] = ans;
    }
}