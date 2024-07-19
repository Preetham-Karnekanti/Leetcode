class Solution {
    int dp[];

    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, helper(nums, i));
        }
        return max;
    }

    public int helper(int nums[], int idx) {
        if (idx == nums.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int max = 1;
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] > nums[idx])
                max = Math.max(max, 1 + helper(nums, i));
        }
        return dp[idx] = max;
    }
}