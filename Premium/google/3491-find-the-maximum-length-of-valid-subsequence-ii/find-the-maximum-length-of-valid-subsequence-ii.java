class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int rem = (nums[i] % k + nums[j] % k) % k;
                dp[i][rem] = Math.max(dp[i][rem], dp[j][rem] + 1);
                ans = Math.max(ans, dp[i][rem]);
            }
        }
        return ans;
    }
}