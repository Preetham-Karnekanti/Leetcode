class Solution {
    int dp[];

    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
        }
        dp = new int[max + 3];
        int freq[] = new int[max + 1];
        for (int i : nums)
            freq[i]++;
        for (int idx = freq.length - 1; idx >= 0; idx--) {
            int notTake = dp[idx + 1];
            int take = freq[idx] * idx + dp[idx + 2];
            dp[idx] = Math.max(take, notTake);
        }
        return dp[1];
    }

    public int helper(int[] freq, int idx) {
        if (idx >= freq.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int notTake = helper(freq, idx + 1);
        int take = freq[idx] * idx + helper(freq, idx + 2);
        return dp[idx] = Math.max(notTake, take);
    }
}