class Solution {
    public int maximumJumps(int[] nums, int target) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        int max = helper(nums, 0, target, dp);
        return max < 0 ? -1 : max;
    }

    public int helper(int nums[], int idx, long target, int[] dp) {
        if (idx == nums.length - 1)
            return 0;
        if (idx >= nums.length)
            return -(int) 1e8;
        if (dp[idx] != -1)
            return dp[idx];
        int take = -(int) 1e8;
        for (int j = idx + 1; j < nums.length; j++) {
            long diff = (long)nums[j] - (long)nums[idx];
            if (diff >= -target && diff <= target) {
                take = Math.max(take, 1 + helper(nums, j, target, dp));
            }
        }
        return dp[idx] = take;
    }
}