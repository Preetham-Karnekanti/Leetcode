class Solution {
    Integer dp[];

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int c = 0;
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(b, nums[i] + a);
            a = b;
            b = c;
        }
        return b;
    }

    public int helper(int nums[], int idx) {
        if (idx >= nums.length)
            return 0;
        if (dp[idx] != null)
            return dp[idx];
        return dp[idx] = Math.max(helper(nums, idx + 1), nums[idx] + helper(nums, idx + 2));
    }
}