class Solution {
    int dp[][];

    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] cost = new int[len + 2];
        for (int i = 0; i < len; i++)
            cost[i + 1] = cuts[i];
        cost[0] = 0;
        cost[len + 1] = n;
        dp = new int[cost.length][cost.length];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        Arrays.sort(cost);
        return helper(cost, 1, cost.length - 2);
    }

    public int helper(int[] cuts, int i, int j) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int min = (int) 1e9;
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1] + helper(cuts, i, k - 1) + helper(cuts, k + 1, j);
            min = Math.min(cost, min);
        }
        return dp[i][j] = min;
    }
}