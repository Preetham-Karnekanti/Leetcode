class Solution {
    int dp[][];

    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int i : nums)
            max = i | max;
        dp = new int[nums.length][max + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(nums, 0, 0, max);
    }

    public int helper(int nums[], int idx, int or, int max) {
        if (idx == nums.length)
            return or == max ? 1 : 0;
        if (dp[idx][or] != -1)
            return dp[idx][or];
        int take = helper(nums, idx + 1, or | nums[idx], max);
        int notTake = helper(nums, idx + 1, or, max);
        return dp[idx][or] = take + notTake;
    }
}