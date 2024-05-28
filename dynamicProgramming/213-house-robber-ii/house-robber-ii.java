class Solution {

    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp, -1);
        Arrays.fill(dp1, -1);
        int n = nums.length;
        return Math.max(helper(nums, n - 2, 0, dp), helper(nums, n - 1, 1, dp1));
    }

    public int helper(int nums[], int idx, int end, int[] dp) {
        if (idx < 0)
            return 0;
        if (idx < end)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int take = nums[idx] + helper(nums, idx - 2, end, dp);
        int notTake = helper(nums, idx - 1, end, dp);
        return dp[idx] = Math.max(take, notTake);
    }
}