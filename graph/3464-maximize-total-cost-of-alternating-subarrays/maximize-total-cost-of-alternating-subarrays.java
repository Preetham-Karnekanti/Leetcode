class Solution {
    Long dp[][];

    public long maximumTotalCost(int[] nums) {
        dp = new Long[nums.length + 1][3];
        return helper(nums, 0, 1);
    }

    public long helper(int[] nums, int idx, int sign) {
        if (idx == nums.length)
            return 0;
        if (dp[idx][sign + 1] != null)
            return dp[idx][sign + 1];
        long sum1 = nums[idx] * sign;
        long sum2 = nums[idx];
        long ans = Math.max(sum1 + helper(nums, idx + 1, sign * -1), sum2 + helper(nums, idx + 1, -1));
        return dp[idx][sign + 1] = ans;
    }
}