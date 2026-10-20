class Solution {
    Integer dp[][];

    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length + 1][nums.length + 1];
        return helper(nums, 0, -1);
    }

    public int helper(int nums[], int idx, int prev) {
        if (idx == nums.length)
            return 0;
        if (dp[idx][prev + 1] != null)
            return dp[idx][prev + 1];
        int skip = helper(nums, idx + 1, prev);
        int take = 0;
        if (prev == -1 || nums[idx] > nums[prev])
            take = 1 + helper(nums, idx + 1, idx);
        return dp[idx][prev + 1] = Math.max(skip, take);
    }
}