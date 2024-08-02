class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int dp[][] = new int[nums.size()][target + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        int ans = helper(nums, target, 0, dp);
        return ans < 0 ? -1 : ans;
    }

    public int helper(List<Integer> nums, int target, int idx, int[][] dp) {
        if (idx == nums.size()) {
            if (target == 0) {
                return 0;
            }
            return -(int) 1e9;
        }
        if (dp[idx][target] != -1)
            return dp[idx][target];
        int take = -(int) 1e9;
        if (target >= nums.get(idx))
            take = 1 + helper(nums, target - nums.get(idx), idx + 1, dp);
        int skip = helper(nums, target, idx + 1, dp);
        return dp[idx][target] = Math.max(take, skip);
    }
}