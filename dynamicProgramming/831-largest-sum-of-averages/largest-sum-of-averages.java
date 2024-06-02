class Solution {
    Double dp[][];

    public double largestSumOfAverages(int[] nums, int k) {
        dp = new Double[nums.length][k + 1];
        return helper(nums, 0, k);
    }

    public double helper(int nums[], int idx, int k) {
        if (k == 0)
            return idx == nums.length ? 0 : -(int) 1e9;
        if (idx == nums.length)
            return 0;
        if (dp[idx][k] != null)
            return dp[idx][k];
        double sum = 0;
        double len = 0;
        double avg = 0.0;
        for (int i = idx; i < nums.length; i++) {
            sum += nums[i];
            len++;
            avg = Math.max(avg, (sum / len) + helper(nums, i + 1, k - 1));
        }
        return dp[idx][k] = avg;
    }
}