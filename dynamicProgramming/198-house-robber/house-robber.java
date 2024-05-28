class Solution {
    static int dp[];

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[nums.length];
    }

    public int helper(int[] nums, int idx) {
        if (idx < 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        return dp[idx] = Math.max(helper(nums, idx - 1), nums[idx] + helper(nums, idx - 2));
    }
}