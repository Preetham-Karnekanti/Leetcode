class Solution {
    Integer dp[][];

    public int splitArray(int[] nums, int k) {
        dp = new Integer[nums.length][k + 1];
        return helper(nums, k, 0);
    }

    public int helper(int[] nums, int k, int idx) {
        if (k == 0 && idx == nums.length)
            return 0;
        if (idx == nums.length || k == 0)
            return (int) 1e9;
        if (dp[idx][k] != null)
            return dp[idx][k];
        int sum = 0, res = (int) 1e9;
        for (int i = idx; i < nums.length; i++) {
            sum = sum + nums[i];
            int nextsum = helper(nums, k - 1, i + 1);
            res = Math.min(res, Math.max(sum, nextsum));
        }
        return dp[idx][k] = res;
    }
}