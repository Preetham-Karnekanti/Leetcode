class Solution {
    Integer dp[][][];

    public int findMaxForm(String[] strs, int m, int n) {
        dp = new Integer[strs.length][m + 1][n + 1];
        return helper(strs, m, n, 0);
    }

    public int helper(String[] nums, int m, int n, int idx) {
        if (idx == nums.length)
            return 0;
        if (dp[idx][m][n] != null)
            return dp[idx][m][n];
        int notTake = helper(nums, m, n, idx + 1);
        int count[] = countOnesAndZeros(nums[idx]);
        int take = 0;
        if (count[0] <= m && count[1] <= n)
            take = 1 + helper(nums, m - count[0], n - count[1], idx + 1);
        return dp[idx][m][n] = Math.max(take, notTake);
    }

    public int[] countOnesAndZeros(String str) {
        int ones = 0, zeros = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                zeros++;
            else
                ones++;
        }
        return new int[] { zeros, ones };
    }
}