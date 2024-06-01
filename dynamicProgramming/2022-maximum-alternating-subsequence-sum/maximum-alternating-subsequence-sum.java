class Solution {
    long dp[][];

    public long maxAlternatingSum(int[] nums) {
        dp = new long[nums.length][2];
        for(long[] i:dp)
            Arrays.fill(i, -1);
        return helper(nums, 0, 1);
    }

    public long helper(int nums[], int idx, int take) {
        if (idx == nums.length) {
            return 0;
        }
        if (dp[idx][take] != -1)
            return dp[idx][take];
        long one = 0, two = 0;
        if (take == 1) {
            return dp[idx][take] = Math.max(helper(nums, idx + 1, 1), helper(nums, idx + 1, 0) + nums[idx]);
        } else
            return dp[idx][take] = Math.max(helper(nums, idx + 1, take), -nums[idx] + helper(nums, idx + 1, 1));
    }
}