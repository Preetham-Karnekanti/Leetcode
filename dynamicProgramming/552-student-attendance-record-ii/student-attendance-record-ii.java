class Solution {
    int m = (int) 1e9 + 7;
    int dp[][][];

    public int checkRecord(int n) {
        dp = new int[n + 1][2][3];
        for (int i[][] : dp) {
            for (int j[] : i)
                Arrays.fill(j, -1);
        }
        return helper(n, 1, 2);
    }

    public int helper(int n, int A, int L) {
        if (n == 0)
            return 1;
        if (dp[n][A][L] != -1)
            return dp[n][A][L];
        int count = 0;
        count = helper(n - 1, A, 2);
        if (A > 0) {
            count += helper(n - 1, A - 1, 2);
            count %= m;
        }
        if (L > 0) {
            count += helper(n - 1, A, L - 1);
            count %= m;
        }
        return dp[n][A][L] = count;
    }
}