class Solution {
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }

    public boolean helper(int[] nums, int idx, int[] dp) {
        if (idx == nums.length - 1)
            return true;
        if (idx > nums.length - 1)
            return false;
        if (dp[idx] != -1)
            return dp[idx] == 0 ? false : true;
        boolean ans = false;
        for (int i = 1; i <= nums[idx]; i++) {
            ans = ans || helper(nums, idx + i, dp);
        }
        dp[idx] = ans == false ? 0 : 1;
        return ans;
    }
}