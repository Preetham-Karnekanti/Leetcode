class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }

    public int helper(int nums[], int idx, int[] dp) {
        if (idx >= nums.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int max = 0;
        for (int j = idx + 1; j < nums.length; j++) {
            max = Math.max(max, (j - idx) * nums[j] + helper(nums, j, dp));
        }
        return dp[idx] = max;
    }
}