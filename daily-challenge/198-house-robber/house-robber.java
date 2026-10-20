class Solution {
    Integer dp[];

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        dp = new Integer[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }

    public int helper(int nums[], int idx) {
        if (idx >= nums.length)
            return 0;
        if (dp[idx] != null)
            return dp[idx];
        return dp[idx] = Math.max(helper(nums, idx + 1), nums[idx] + helper(nums, idx + 2));
    }
}