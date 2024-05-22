class Solution {
    int dp[][];

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(text1, text2, 0, 0);
    }

    public int helper(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int one = -1;
        int two = -1;
        if (s1.charAt(i) == s2.charAt(j)) {
            one = 1 + helper(s1, s2, i + 1, j + 1);
        } else {
            two = Math.max(helper(s1, s2, i + 1, j), helper(s1, s2, i, j + 1));
        }
        return dp[i][j] = Math.max(one, two);
    }
}