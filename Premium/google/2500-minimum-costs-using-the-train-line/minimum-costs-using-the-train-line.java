class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long dp[][] = new long[2][n];
        for (long i[] : dp)
            Arrays.fill(i, -1);
        long minCost = helper(regular, express, expressCost, n - 1, 0, dp);
        return dp[0];
    }

    public long helper(int regular[], int[] express, int expressCost, int idx, int lane, long[][] dp) {
        if (idx < 0)
            return 0;
        if (dp[lane][idx] != -1)
            return dp[lane][idx];
        if (lane == 0) {
            long sameLane = regular[idx] + helper(regular, express, expressCost, idx - 1, lane, dp);
            long differentLane = expressCost + express[idx]
                    + helper(regular, express, expressCost, idx - 1, 1 - lane, dp);
            return dp[lane][idx] = Math.min(sameLane, differentLane);
        } else {
            long sameLane = express[idx] + helper(regular, express, expressCost, idx - 1, lane, dp);
            long differentLane = regular[idx] + helper(regular, express, expressCost, idx - 1, 1 - lane, dp);
            return dp[lane][idx] = Math.min(sameLane, differentLane);
        }
    }
}