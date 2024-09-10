class Solution {
    public int validSubarraySplit(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans = helper(nums, 0, dp);
        return ans == (int) 1e9 ? -1 : ans;
    }

    public int helper(int nums[], int idx, int[] dp) {
        if (idx == nums.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int min = (int) 1e9;
        for (int i = idx; i < nums.length; i++) {
            if (gcd(nums[i], nums[idx]) > 1) {
                min = Math.min(min, 1 + helper(nums, i + 1, dp));
            }
        }
        return dp[idx] = min;
    }

    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}