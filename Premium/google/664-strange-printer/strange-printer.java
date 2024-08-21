class Solution {
    public int strangePrinter(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(s, 0, s.length() - 1, dp);
    }

    public int helper(String s, int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int min = 1 + helper(s, i + 1, j, dp);
        char first = s.charAt(i);
        for (int k = i + 1; k <= j; k++) {
            if (s.charAt(k) == first) {
                int turnsWithMatch = helper(s, i, k - 1, dp) + helper(s, k + 1, j, dp);
                min = Math.min(min, turnsWithMatch);
            }
        }
        return dp[i][j] = min;
    }
}