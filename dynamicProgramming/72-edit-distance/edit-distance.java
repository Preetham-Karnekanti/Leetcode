class Solution {
    int dp[][];

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;
        for (int i = 0; i <= word2.length(); i++)
            dp[0][i] = i;
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public int helper(String s1, String s2, int i, int j) {
        if (i == 0)
            return j;
        if (j == 0)
            return i;
        if (dp[i][j] != -1)
            return dp[i][j];
        int one = (int) 1e6, two = (int) 1e6;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = helper(s1, s2, i - 1, j - 1);
        }
        return dp[i][j] = 1
                + Math.min(helper(s1, s2, i - 1, j), Math.min(helper(s1, s2, i - 1, j - 1), helper(s1, s2, i, j - 1)));
    }
}