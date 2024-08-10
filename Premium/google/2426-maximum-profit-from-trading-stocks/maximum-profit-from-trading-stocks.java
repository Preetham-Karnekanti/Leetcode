class Solution {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int dp[][] = new int[budget + 1][present.length];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(present, future, budget, 0, dp);
    }

    public int helper(int[] present, int[] future, int budget, int idx, int[][] dp) {
        if (idx == present.length)
            return 0;
        if (dp[budget][idx] != -1)
            return dp[budget][idx];
        int take = 0;
        if (present[idx] <= budget)
            take = future[idx] - present[idx] + helper(present, future, budget - present[idx], idx + 1, dp);
        int skip = helper(present, future, budget, idx + 1, dp);
        return dp[budget][idx] = Math.max(take, skip);
    }
}