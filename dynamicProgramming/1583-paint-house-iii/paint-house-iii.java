class Solution {
    Integer dp[][][];

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new Integer[101][22][101];
        int val = helper(houses, cost, 0, -1, m, n, target);
        return val >= (int) 1e7 ? -1 : val;
    }

    public int helper(int houses[], int[][] cost, int idx, int prev, int m, int n, int target) {
        if (idx == m) {
            if (target == 0)
                return 0;
            return (int) 1e7;
        }
        if (target < 0)
            return (int) 1e7;
        if (dp[idx][prev + 1][target] != null)
            return dp[idx][prev + 1][target];
        if (houses[idx] != 0)
            return dp[idx][prev + 1][target] = helper(houses, cost, idx + 1, houses[idx], m, n,
                    prev != houses[idx] ? target - 1 : target);
        else {
            int min = (int) 1e7;
            for (int color = 1; color <= n; color++)// Choose any color
                min = Math.min(min, cost[idx][color - 1]
                        + helper(houses, cost, idx + 1, color, m, n, color != prev ? target - 1 : target));
            return dp[idx][prev + 1][target] = min;
        }
    }
}