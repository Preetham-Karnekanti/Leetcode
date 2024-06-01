class Solution {
    Integer dp[][];

    public int maxSumDivThree(int[] nums) {
        dp = new Integer[nums.length][3];
        return helper(nums, 0, 0);
    }

    public int helper(int nums[], int idx, int mod) {
        if (idx == nums.length) {
            if (mod == 0)
                return 0;
            return -10000000;
        }
        if (dp[idx][mod] != null)
            return dp[idx][mod];
        int take = nums[idx] + helper(nums, idx + 1, (mod + nums[idx]) % 3);
        int left = helper(nums, idx + 1, mod);
        return dp[idx][mod] = Math.max(take, left);
    }
}