class Solution {
    // int dp[][];

    public int lengthOfLIS(int[] nums) {
        int pre[] = new int[nums.length + 1];
        for (int idx = nums.length - 1; idx >= 0; idx--) {
            int cur[] = new int[nums.length + 1];
            for (int prev = idx - 1; prev >= -1; prev--) {
                int notTake = pre[prev + 1];
                int take = 0;
                if (prev == -1 || nums[idx] > nums[prev]) {
                    take = 1 + pre[idx + 1];
                }
                cur[prev + 1] = Math.max(take, notTake);
            }
            pre = cur;
        }
        return pre[0];
    }

    // public int helper(int nums[], int idx, int prev) {
    // if (idx == nums.length)
    // return 0;
    // if (dp[idx][prev + 1] != -1)
    // return dp[idx][prev + 1];
    // int notTake = helper(nums, idx + 1, prev);
    // int take = 0;
    // if (prev == -1 || nums[idx] > nums[prev]) {
    // take = 1 + helper(nums, idx + 1, idx);
    // }
    // return dp[idx][prev + 1] = Math.max(take, notTake);
    // }
}