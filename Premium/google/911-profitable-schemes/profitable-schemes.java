class Solution {
    int mod = (int) 1e9 + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int sum = 0;
        for (int i = 0; i < profit.length; i++) {
            sum += profit[i];
        }
        Integer dp[][][] = new Integer[n + 1][group.length][sum + 1];
        return helper(n, minProfit, group, profit, 0, 0, dp);
    }

    public int helper(int n, int minProfit, int group[], int profit[], int idx, int profitSoFar, Integer[][][] dp) {
        if (idx == group.length) {
            return profitSoFar >= minProfit ? 1 : 0;
        }
        if (dp[n][idx][profitSoFar] != null)
            return dp[n][idx][profitSoFar];
        int take = 0;
        if (group[idx] <= n) {
            take = helper(n - group[idx], minProfit, group, profit, idx + 1, profitSoFar + profit[idx], dp);
        }
        int skip = helper(n, minProfit, group, profit, idx + 1, profitSoFar, dp);
        return dp[n][idx][profitSoFar] = (take + skip) % mod;
    }
}