class Solution {
    int dp[][];

    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (i == 0 || j == 0)
                    continue;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public int helper(String s, String t, int i, int j) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            count = helper(s, t, i + 1, j + 1) + helper(s, t, i + 1, j);
        } else
            count = helper(s, t, i + 1, j);
        return dp[i][j] = count;
    }
}