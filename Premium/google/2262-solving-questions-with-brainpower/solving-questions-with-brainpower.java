class Solution {
    public long mostPoints(int[][] questions) {
        long dp[] = new long[questions.length];
        Arrays.fill(dp, -1);
        return helper(questions, 0, dp);
    }

    public long helper(int[][] questions, int idx,long[] dp){
        if(idx >= questions.length)
            return 0;
        if(dp[idx] != -1)
            return dp[idx];
        long skip = helper(questions, idx + 1, dp);
        long solve = questions[idx][0] + helper(questions, idx + questions[idx][1] + 1, dp);
        return dp[idx] = Math.max(skip, solve);
    }
}