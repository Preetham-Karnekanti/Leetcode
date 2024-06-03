class Solution {
    int dp[][];

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n)
            return -1;
        dp = new int[n][d + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(jobDifficulty, 0, d);
    }

    public int helper(int nums[], int idx, int d) {
        if (idx == nums.length) {
            if (d == 0)
                return 0;
            return (int) 1e9;
        }
        if (d < 0)
            return (int) 1e9;
        if (dp[idx][d] != -1)
            return dp[idx][d];
        int max = -1;
        int res = (int) 1e9;
        for (int i = idx; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            res = Math.min(res, max + helper(nums, i + 1, d - 1));
        }
        return dp[idx][d] = res;
    }
}