class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        Arrays.fill(dp, -1);
        return solve(0, costs, days, dp);
    }

    int solve(int index, int[] costs, int[] days, int[] dp) {
        if (index >= days.length)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        // Oneday Pass

        int one = costs[0] + solve(index + 1, costs, days, dp);

        // Seven Day
        int sevenEndDay = days[index] + 7 - 1;
        int sevenEndIndex = index + 1;
        for (; sevenEndIndex < days.length; sevenEndIndex++) {
            if (days[sevenEndIndex] > sevenEndDay) {
                break;
            }
        }
        int seven = costs[1] + solve(sevenEndIndex, costs, days, dp);

        int endDay = days[index] + 30 - 1;
        int endIndex = index + 1;
        for (; endIndex < days.length; endIndex++) {
            if (days[endIndex] > endDay) {
                break;
            }
        }
        int thirty = costs[2] + solve(endIndex, costs, days, dp);

        return dp[index] = Math.min(one, Math.min(thirty, seven));

    }
}