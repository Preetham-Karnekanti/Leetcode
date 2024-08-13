class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int dp[][] = new int[n][k + 1];
        for (int []i : dp)
            Arrays.fill(i, -1);
        return helper(costs, 0, -1, k, dp);
    }

    public int helper(int costs[][], int idx, int prevColor, int k, int[][] dp) {
        if (idx == costs.length)
            return 0;
        if (dp[idx][prevColor + 1] != -1)
            return dp[idx][prevColor + 1];
        int min = (int) 1e9;
        for (int i = 0; i < k; i++) {
            if (prevColor != i) {
                min = Math.min(min, costs[idx][i] + helper(costs, idx + 1, i, k, dp));
            }
        }
        return dp[idx][prevColor + 1] = min;
    }
}