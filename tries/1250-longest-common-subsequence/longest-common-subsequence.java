class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(text1, text2, 0, 0, dp);
    }

    public int helper(String s1, String s2, int i, int j, int[][] dp) {
        if (s1.length() == i || s2.length() == j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + helper(s1, s2, i + 1, j + 1, dp);
        return dp[i][j] = Math.max(helper(s1, s2, i + 1, j, dp), helper(s1, s2, i, j + 1, dp));
    }
}