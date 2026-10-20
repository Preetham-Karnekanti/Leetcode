class Solution {
    Integer dp[];

    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length + 1];
        int max = 0;
        for (int i = 0; i < nums.length; i++)
            max = Math.max(max, helper(nums, i));
        return max;
    }

    public int helper(int nums[], int idx) {
        if (idx == nums.length)
            return 0;
        if (dp[idx] != null)
            return dp[idx];
        int take = 1;
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] > nums[idx]) {
                take = Math.max(take, 1 + helper(nums, i));
            }
        }
        return dp[idx] = take;
    }
}