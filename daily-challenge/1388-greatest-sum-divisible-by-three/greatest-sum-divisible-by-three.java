class Solution {
    int dp[][];
    public int maxSumDivThree(int[] nums) {
        dp = new int[nums.length][3];
        return helper(nums, 0, 0);
    }

    public int helper(int nums[], int idx, int mod) {
        if (idx == nums.length) {
            return mod == 0 ? mod : (int) -1e9;
        }
        if(dp[idx][mod] != 0)
            return dp[idx][mod];
        int pick = nums[idx] + helper(nums, idx + 1, (mod + nums[idx]) % 3);
        int notPick = helper(nums, idx + 1, mod);
        return dp[idx][mod] = Math.max(pick, notPick);
    }
}