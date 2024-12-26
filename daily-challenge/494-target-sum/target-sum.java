class Solution {
    int totalSum;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();
        int[][] memo = new int[nums.length][2 * totalSum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return helper(nums, 0, target, 0, memo);
    }

    public int helper(int nums[], int idx, int target, int currentSum, int dp[][]) {
        if (target == currentSum && idx == nums.length)
            return 1;
        if (idx == nums.length)
            return 0;
        if (dp[idx][currentSum + totalSum] != Integer.MIN_VALUE)
            return dp[idx][currentSum + totalSum];
        return dp[idx][currentSum + totalSum] = helper(nums, idx + 1, target, currentSum - nums[idx], dp)
                + helper(nums, idx + 1, target, currentSum + nums[idx], dp);
    }
}