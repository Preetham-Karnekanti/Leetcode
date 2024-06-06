class Solution {
    Integer dp[][];

    public int longestArithSeqLength(int[] nums) {
        dp = new Integer[nums.length][1003];
        return helper(nums, 0, -501);
    }

    public int helper(int nums[], int idx, int diff) {
        if (idx >= nums.length)
            return 0;
        if (dp[idx][diff + 501] != null)
            return dp[idx][diff + 501];
        int res = 1;

        if (diff == -501) {
            for (int j = idx + 1; j < nums.length; j++) {
                int take = 1 + helper(nums, j, nums[j] - nums[idx]);
                int notTake = helper(nums, j, diff);
                res = Math.max(res, Math.max(take, notTake));
            }
        } else {
            for (int j = idx + 1; j < nums.length; j++) {
                int take = 0;
                if (diff == nums[j] - nums[idx])
                    take = 1 + helper(nums, j, nums[j] - nums[idx]);
                res = Math.max(res, take);

            }
        }
        return dp[idx][diff + 501] = res;
    }
}