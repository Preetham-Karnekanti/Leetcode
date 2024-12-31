class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days.length];
        Arrays.fill(dp, -1);
        return helper(days, costs, 0, dp);
    }

    public int helper(int days[], int costs[], int idx, int[] dp) {
        if (idx >= days.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int oneDayPass = costs[0] + helper(days, costs, idx + 1, dp);
        int sevenDaysPass = 0;
        int validTill = days[idx] + 6;
        int validIdx = idx;
        while (validIdx < days.length && days[validIdx] <= validTill)
            validIdx++;
        sevenDaysPass = costs[1] + helper(days, costs, validIdx, dp);
        int thirtyDayPass = 0;
        validTill = days[idx] + 29;
        validIdx = idx;
        while (validIdx < days.length && days[validIdx] <= validTill)
            validIdx++;
        thirtyDayPass = costs[2] + helper(days, costs, validIdx, dp);
        return dp[idx] = Math.min(oneDayPass, Math.min(sevenDaysPass, thirtyDayPass));
    }
}