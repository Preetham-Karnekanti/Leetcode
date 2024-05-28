class Solution {
    static int dp[];

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, nums.length - 1);
    }

    public int helper(int[] nums, int idx) {
        if (idx < 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        return dp[idx] = Math.max(helper(nums, idx - 1), nums[idx] + helper(nums, idx - 2));
    }
}