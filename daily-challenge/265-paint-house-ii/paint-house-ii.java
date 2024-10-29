class Solution {
    int dp[][];

    public int minCostII(int[][] costs) {
        dp = new int[costs.length][costs[0].length];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            for (int color = 0; color < costs[0].length; color++) {
                int min = Integer.MAX_VALUE;
                for (int prevColor = 0; prevColor < costs[0].length; prevColor++) {
                    if (color != prevColor) {
                        int curCost = costs[i][color] + dp[i - 1][prevColor];
                        min = Math.min(min, curCost);
                    }
                }
                dp[i][color] = min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            min = Math.min(min, dp[costs.length - 1][i]);
        }
        return min;
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