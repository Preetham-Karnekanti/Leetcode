class Solution {
    int dp[][];

    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][t.length()] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
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