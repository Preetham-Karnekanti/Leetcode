class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, 0), helper(cost, 1));
    }

    public int helper(int[] cost, int idx) {
        if (idx >= cost.length)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int min = helper(cost, idx + 1);
        min = Math.min(min, helper(cost, idx + 2));
        min = min + cost[idx];
        dp[idx] = min;
        return min;
    }
}