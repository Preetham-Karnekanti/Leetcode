class Solution {

    public int maxSizeSlices(int[] slices) {
        Integer dp1[][];
        Integer dp2[][];
        int n = slices.length;
        int c = n / 3;
        dp1 = new Integer[n][c + 1];
        dp2 = new Integer[n][c + 1];
        return Math.max(helper(slices, 0, n - 2, n / 3, dp1), helper(slices, 1, n - 1, n / 3, dp2));
    }

    public int helper(int[] slices, int start, int end, int rem, Integer dp[][]) {
        if (start > end)
            return 0;
        if (dp[start][rem] != null)
            return dp[start][rem];
        int notTake = helper(slices, start + 1, end, rem, dp);
        int take = 0;
        if (rem > 0)
            take = slices[start] + helper(slices, start + 2, end, rem - 1, dp);
        return dp[start][rem] = Math.max(take, notTake);
    }
}