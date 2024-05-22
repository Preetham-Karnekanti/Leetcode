class Solution {
    int dp[];

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0);
    }

    public int helper(int nums[], int idx) {
        if (idx >= nums.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int take = nums[idx] + helper(nums, idx + 2);
        int notTake = helper(nums, idx + 1);
        return dp[idx] = Math.max(take, notTake);
    }
}