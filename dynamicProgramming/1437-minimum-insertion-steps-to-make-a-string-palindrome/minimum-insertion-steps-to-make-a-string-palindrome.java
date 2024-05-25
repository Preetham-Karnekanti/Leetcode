class Solution {
    int dp[][];

    public int minInsertions(String s) {
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            Arrays.fill(dp[i], -1);
        String str = new StringBuilder(s).reverse().toString();
        return helper(str, s, 0, 0) / 2;
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