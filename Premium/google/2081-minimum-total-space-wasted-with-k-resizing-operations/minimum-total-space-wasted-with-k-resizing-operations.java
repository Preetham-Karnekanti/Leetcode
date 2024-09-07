class Solution {
    int dp[][];

    public int minSpaceWastedKResizing(int[] nums, int k) {
        dp = new int[nums.length][k + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(nums, 0, k);
    }

    public int helper(int nums[], int idx, int k) {
        if (idx == nums.length)
            return 0;
        if (k < 0)
            return (int) 1e9;
        if (dp[idx][k] != -1)
            return dp[idx][k];
        int totalSum = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = idx; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            totalSum += nums[i];
            /*
             * total waste in between [idx...j] would be
             * summation of (max-nums[idx] + max-nums[idx+1]....max-nums[j])
             * length would be (j-idx+1) and these summation would be
             * (j-idx+1) * max upto j - (nums[idx]+nums[idx+1]....+nums[j]
             */
            int totalSpaceWastedTillJ = (i - idx + 1) * max - totalSum;
            min = Math.min(min, totalSpaceWastedTillJ + helper(nums, i + 1, k - 1));
        }
        return dp[idx][k] = min;
    }
}