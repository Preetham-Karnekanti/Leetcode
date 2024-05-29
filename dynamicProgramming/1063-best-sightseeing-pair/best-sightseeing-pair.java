class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        var maxScore = 0;
        var n = values.length;
        var dp = new int[n];
        dp[0] = values[0];

        for (var i = 1; i < n; i++) {
            maxScore = Math.max(maxScore, dp[i - 1] + values[i] - i);
            dp[i] = Math.max(dp[i - 1], values[i] + i);
        }
        return maxScore;
    }
}