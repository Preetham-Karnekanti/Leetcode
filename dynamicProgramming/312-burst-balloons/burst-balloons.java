class Solution {
    int dp[][];

    public int maxCoins(int[] nums) {
        int newNums[] = new int[nums.length + 2];
        dp = new int[nums.length + 2][nums.length + 2];
        // for (int i[] : dp)
        // Arrays.fill(i, -1);
        Arrays.fill(newNums, 1);
        for (int i = 0; i < nums.length; i++)
            newNums[i + 1] = nums[i];
        for (int i = nums.length; i >= 1; i--) {
            for (int j = 0; j <= nums.length; j++) {
                int max = 0;
                for (int k = i; k <= j; k++) {
                    int points = newNums[i - 1] * newNums[k] * newNums[j + 1] + dp[i][k - 1] + dp[k + 1][j];
                    max = Math.max(points, max);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][newNums.length - 2];
        // return helper(newNums, 1, newNums.length - 2);
    }

    public int helper(int nums[], int i, int j) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int max = 0;
        for (int k = i; k <= j; k++) {
            int points = nums[i - 1] * nums[k] * nums[j + 1] + helper(nums, i, k - 1) + helper(nums, k + 1, j);
            max = Math.max(points, max);
        }
        return dp[i][j] = max;
    }
}