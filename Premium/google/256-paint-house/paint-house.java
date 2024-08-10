class Solution {
    public int minCost(int[][] costs) {
        int dp[][] = new int[costs.length][4];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(costs, 0, -1, dp);
    }

    public int helper(int[][] costs, int idx, int prevColor, int[][] dp) {
        if (idx == costs.length)
            return 0;
        if (dp[idx][prevColor + 1] != -1)
            return dp[idx][prevColor + 1];
        int minCost = (int) 1e9;
        for (int color = 0; color < 3; color++) {
            if (color != prevColor)
                minCost = Math.min(minCost, costs[idx][color] + helper(costs, idx + 1, color, dp));
        }
        return dp[idx][prevColor + 1] = minCost;
    }
}