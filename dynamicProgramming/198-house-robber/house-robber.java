class Solution {
    int dp[];

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        dp = new int[nums.length + 1];
        int prev1 = 0;
        int prev = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            int cur = Math.max(prev, prev1 + nums[i - 1]);
            prev1 = prev;
            prev = cur;
        }
        return prev;
    }

    public int helper(int nums[], int idx) {
        if (idx < 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int take = nums[idx] + helper(nums, idx - 2);
        int notTake = helper(nums, idx - 1);
        return dp[idx] = Math.max(take, notTake);
    }
}