class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length()][p.length()];
        return helper(s, p, 0, 0, dp);
    }

    public boolean helper(String s, String p, int i, int j, Boolean dp[][]) {
        if (j == p.length())
            return i == s.length();
        if (i == s.length()) {
            for (int jj = j; jj < p.length(); jj++) {
                if (p.charAt(jj) != '*')
                    return false;
            }
            return true;
        }
        if (dp[i][j] != null)
            return dp[i][j];
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return dp[i][j] = helper(s, p, i + 1, j + 1, dp);
        if (p.charAt(j) == '*') {
            return dp[i][j] = helper(s, p, i, j + 1, dp) || helper(s, p, i + 1, j, dp);
        }
        return dp[i][j] = false;
    }
}