class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long dp[] = new long[m];
        for (int i = 0; i < m; i++)
            dp[i] = points[0][i];
        for (int i = 1; i < n; i++) {
            long left[] = new long[m];
            long right[] = new long[m];
            long newDp[] = new long[m];
            left[0] = dp[0];
            for (int j = 1; j < m; j++)
                left[j] = Math.max(left[j - 1] - 1, dp[j]);
            right[m - 1] = dp[m - 1];
            for (int j = m - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, dp[j]);
            }
            for (int j = 0; j < m; j++)
                newDp[j] = Math.max(right[j], left[j]) + points[i][j];
            dp = newDp;
        }
        long max = 0;
        for (int i = 0; i < m; i++)
            max = Math.max(max, dp[i]);
        return max;
    }
}