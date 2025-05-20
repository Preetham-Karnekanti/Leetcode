class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int dp[][] = new int[nums[i] + 1][queries.length];
            for (int k[] : dp)
                Arrays.fill(k, -1);
            ans = Math.max(ans, helper(i, nums[i], queries, 0, dp));
        }
        return ans == queries.length + 1 ? -1 : ans;
    }

    public int helper(int i, int target, int q[][], int idx, int[][] dp) {
        if (target == 0)
            return idx;
        if (idx >= q.length)
            return q.length + 1;
        if (dp[target][idx] != -1)
            return dp[target][idx];
        int one = helper(i, target, q, idx + 1, dp);
        int two = Integer.MAX_VALUE;
        if (i >= q[idx][0] && i <= q[idx][1] && target >= q[idx][2])
            two = helper(i, target - q[idx][2], q, idx + 1, dp);
        return dp[target][idx] = Math.min(one, two);
    }
}