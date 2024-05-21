class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }

    public int helper(int arr[], int idx, int[] dp) {
        if (idx >= arr.length - 1)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int ans = (int)1e6;
        for (int i = 1; i <= arr[idx]; i++) {
            if (idx + i < arr.length) {
                ans = Math.min(ans, 1 + helper(arr, idx + i, dp));
            }
        }
        dp[idx] = ans;
        return ans;
    }
}