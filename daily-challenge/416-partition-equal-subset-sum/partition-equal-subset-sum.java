class Solution {
    static Boolean dp[][];

    public boolean canPartition(int[] input) {
        int sum = 0;
        for (int i : input)
            sum += i;
        if (sum % 2 == 1)
            return false;
        sum = sum / 2;
        dp = new Boolean[input.length][sum + 1];
        return helper(input, 0, sum);
    }

    public static boolean helper(int nums[], int idx, int target) {
        if (target == 0)
            return true;
        if(target < 0)
            return false;
        if (idx == nums.length)
            return false;
        if (dp[idx][target] != null)
            return dp[idx][target];
        return dp[idx][target] = helper(nums, idx + 1, target - nums[idx]) || helper(nums, idx + 1, target);
    }
}