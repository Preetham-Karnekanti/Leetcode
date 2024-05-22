class Solution {
    int dp[][];

    public int longestPalindromeSubseq(String s) {
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            Arrays.fill(dp[i], -1);
        StringBuilder s2 = new StringBuilder(s);
        return helper(s, s2.reverse().toString(), 0, 0);
    }

    public int helper(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int one = -1, two = -1;
        if (s1.charAt(i) == s2.charAt(j))
            one = 1 + helper(s1, s2, i + 1, j + 1);
        else
            two = Math.max(helper(s1, s2, i, j + 1), helper(s1, s2, i + 1, j));
        return dp[i][j] = Math.max(one, two);
    }
}