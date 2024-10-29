class Solution {
    int dp[][];

    public int minCostII(int[][] costs) {
        dp = new int[costs.length][costs[0].length + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(costs, 0, -1);
    }

    public int helper(int[][] costs, int idx, int prevColor) {
        if (idx == costs.length)
            return 0;
        if (dp[idx][prevColor + 1] != -1)
            return dp[idx][prevColor + 1];
        int min = Integer.MAX_VALUE;
        for (int color = 0; color < costs[0].length; color++) {
            if (color != prevColor) {
                int curCost = costs[idx][color] + helper(costs, idx + 1, color);
                min = Math.min(min, curCost);
            }
        }
        return dp[idx][prevColor + 1] = min;
    }
}