class Solution {
    int mod = (int) 1e9 + 7;
    Integer dp[][];

    public int numWays(int steps, int arrLen) {
        dp = new Integer[steps + 1][steps + 1];
        return helper(steps, 0, arrLen);
    }

    public int helper(int steps, int idx, int arrLen) {
        if (steps == 0 && idx == 0)
            return 1;
        if (steps < 0 || idx < 0 || idx >= arrLen)
            return 0;
        if (dp[steps][idx] != null)
            return dp[steps][idx];
        int count = 0;
        count = helper(steps - 1, idx, arrLen);
        count = (count + helper(steps - 1, idx + 1, arrLen)) % mod;
        count = (count + helper(steps - 1, idx - 1, arrLen)) % mod;
        return dp[steps][idx] = count;
    }
}