class Solution {
    int dp[][];
    int m = (int) 1e9 + 7;

    public int numberOfWays(int startPos, int endPos, int k) {
        dp = new int[4001][1001];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(startPos, endPos, k);
    }

    public int helper(int idx, int endPos, int k) {
        if (idx == endPos && k == 0)
            return 1;
        if (k == 0)
            return 0;
        if (dp[idx + 2001][k] != -1)
            return dp[idx + 2001][k];
        int ways = (helper(idx + 1, endPos, k - 1) % m + helper(idx - 1, endPos, k - 1) % m) % m;
        return dp[idx + 2001][k] = ways;
    }
}