class Solution {
    int dp[][];

    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] cost = new int[len + 2];
        for (int i = 0; i < len; i++)
            cost[i + 1] = cuts[i];
        cost[0] = 0;
        cost[len + 1] = n;
        dp = new int[cuts.length + 2][cuts.length + 2];

        Arrays.sort(cost);
        for (int i = len; i >= 1; i--) {
            for (int j = 1; j <= len; j++) {
                if (i > j)
                    continue;
                int min = (int) 1e9;
                for (int k = i; k <= j; k++) {
                    int temp = cost[j + 1] - cost[i - 1]
                            + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(temp, min);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][cuts.length];
    }

    // public int helper(int[] cuts, int i, int j) {
    // if (i > j)
    // return 0;
    // if (dp[i][j] != -1)
    // return dp[i][j];
    // int min = (int) 1e9;
    // for (int k = i; k <= j; k++) {
    // int cost = cuts[j + 1] - cuts[i - 1] + helper(cuts, i, k - 1) + helper(cuts,
    // k + 1, j);
    // min = Math.min(cost, min);
    // }
    // return dp[i][j] = min;
    // }
}