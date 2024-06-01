class Solution {
    Integer dp[][];

    public int wiggleMaxLength(int[] nums) {
        dp = new Integer[nums.length][3];
        return helper(nums, 1, 2) + 1;
    }

    public int helper(int nums[], int idx, int sign) {
        if (idx == nums.length)
            return 0;
        if (dp[idx][sign] != null)
            return dp[idx][sign];
        int notTake = helper(nums, idx + 1, sign);
        int take = 0;
        int diff = nums[idx] - nums[idx - 1];
        if ((diff < 0 && sign == 1) || (diff > 0 && sign == 0) || (sign == 2 && diff != 0)) {
            if (diff > 0)
                take = 1 + helper(nums, idx + 1, 1);
            else
                take = 1 + helper(nums, idx + 1, 0);
        }
        return dp[idx][sign] = Math.max(take, notTake);
    }
}