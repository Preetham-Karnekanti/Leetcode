class Solution {
    int dp[][];

    public int lastStoneWeightII(int[] stones) {
        dp = new int[31][3001];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(stones, 0, 0);
    }

    public int helper(int nums[], int idx, int left) {
        if (idx >= nums.length)
            return left;
        if (dp[idx][left] != -1)
            return dp[idx][left];
        int a = helper(nums, idx + 1, left + nums[idx]);
        int b = helper(nums, idx + 1, Math.abs(left - nums[idx]));
        return dp[idx][left] = Math.min(a, b);
    }
}