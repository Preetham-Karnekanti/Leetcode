class Solution {
    int dp[];

    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
        }
        dp = new int[max + 1];
        Arrays.fill(dp, -1);
        int freq[] = new int[max + 1];
        for (int i : nums)
            freq[i]++;
        return helper(freq, 1);
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