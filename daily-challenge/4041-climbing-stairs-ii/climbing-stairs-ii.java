class Solution {
    int dp[];
    public int climbStairs(int n, int[] costs) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(0, n, costs);
    }

    public int helper(int i, int n, int[] costs) {
        if (i > n) {
            return (int) 1e9;
        }
        if (i == n)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        int min = (int) 1e9;
        if (i < costs.length)
            min = Math.min(min, costs[i] + helper(i + 1, n, costs) + 1);
        if (i + 1 < costs.length)
            min = Math.min(min, costs[i + 1] + helper(i + 2, n, costs) + 4);
        if (i + 2 < costs.length)
            min = Math.min(min, costs[i + 2] + helper(i + 3, n, costs) + 9);
        return dp[i] = min;
    }
}