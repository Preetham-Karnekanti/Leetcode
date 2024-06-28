class Solution {
    public boolean validPartition(int[] nums) {
        Boolean dp[] = new Boolean[nums.length];
        return helper(nums, 0, dp);
    }

    public boolean helper(int nums[], int i, Boolean dp[]) {
        int n = nums.length;
        if (i >= n)
            return true;
        if (dp[i] != null)
            return dp[i];
        if (i < n - 1 && nums[i] == nums[i + 1])
            if (helper(nums, i + 2, dp))
                return dp[i] = true;
        if (i < n - 2 && nums[i + 1] == nums[i] && nums[i] == nums[i + 2])
            if (helper(nums, i + 3, dp))
                return dp[i] = true;
        if (i < n - 2 && isIncreasingAndConscecutive(nums[i], nums[i + 1], nums[i + 2]))
            if (helper(nums, i + 3, dp))
                return dp[i] = true;
        return dp[i] = false;
    }

    public boolean isIncreasingAndConscecutive(int a, int b, int c) {
        return b - a == 1 && c - b == 1;
    }
}