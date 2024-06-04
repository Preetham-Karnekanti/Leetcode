class Solution {
    Boolean dp[][];

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return helper(s, p, 0, 0);
    }

    public boolean helper(String s, String p, int i, int j) {
        if (j == p.length())
            return i == s.length();
        if (dp[i][j] != null)
            return dp[i][j];
        else {
            boolean ans = false;
            boolean firstMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                ans = helper(s, p, i, j + 2) || firstMatch && helper(s, p, i + 1, j);
            } else {
                ans = firstMatch && helper(s, p, i + 1, j + 1);
            }
            return dp[i][j] = ans;
        }
    }
}