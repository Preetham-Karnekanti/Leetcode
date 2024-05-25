class Solution {
    int dp[][];

    public int minInsertions(String s) {
        dp = new int[s.length() + 1][s.length() + 1];
        String s2 = new StringBuilder(s).reverse().toString();
        int n = s.length();
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], (int) 1e6);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[n][n];
    }

    public int helper(String s1, String s2, int i, int j) {
        if (i == s1.length())
            return s2.length() - j;
        if (j == s2.length())
            return s1.length() - i;
        if (dp[i][j] != -1)
            return dp[i][j];
        int min = Integer.MAX_VALUE;
        if (s1.charAt(i) == s2.charAt(j))
            return helper(s1, s2, i + 1, j + 1);
        min = 1 + Math.min(helper(s1, s2, i + 1, j), helper(s1, s2, i, j + 1));
        return dp[i][j] = min;
    }
}