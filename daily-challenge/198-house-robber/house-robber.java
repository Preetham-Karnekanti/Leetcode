class Solution {
    Integer dp[];
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return helper(nums, 0);
    }

    public int helper(int nums[], int idx) {
        if (idx >= nums.length)
            return 0;
        if(dp[idx] != null) return dp[idx];
        return dp[idx] = Math.max(helper(nums, idx + 1), nums[idx] + helper(nums, idx + 2));
    }
}