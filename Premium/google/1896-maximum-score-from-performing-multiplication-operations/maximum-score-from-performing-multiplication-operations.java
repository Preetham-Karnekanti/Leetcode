class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int dp[][] = new int[n][m];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(nums, multipliers, 0, 0, dp);
    }

    public int helper(int nums[], int multipliers[], int i, int k, int[][] dp) {
        if (k == multipliers.length)
            return 0;
        if (dp[i][k] != -1)
            return dp[i][k];
        int j = nums.length - 1 - (k - i);
        int start = multipliers[k] * nums[i] + helper(nums, multipliers, i + 1, k + 1, dp);
        int end = multipliers[k] * nums[j] + helper(nums, multipliers, i, k + 1, dp);
        return dp[i][k] = Math.max(start, end);
    }
}