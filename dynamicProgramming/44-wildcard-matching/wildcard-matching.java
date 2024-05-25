class Solution {
    boolean dp[][];

    public boolean isMatch(String s, String p) {
        dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= p.length(); i++) {
            boolean flag = true;
            for (int ii = 1; ii <= i; ii++) {
                if (p.charAt(ii - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }
        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else
                    dp[i][j] = false;
            }
        }
        return dp[p.length()][s.length()];
    }

    // public boolean helper(String p, String s, int i, int j) {
    // if (i == 0 && j == 0)
    // return true;
    // if (i == 0 && j > 0)
    // return false;
    // if (j == 0 && i > 0) {
    // for (int ii = 0; ii < i; ii++)
    // if (p.charAt(ii) != '*')
    // return false;
    // return true;
    // }
    // if (dp[i][j] != -1)
    // return dp[i][j] == 0 ? false : true;
    // if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
    // boolean val = helper(p, s, i - 1, j - 1);
    // dp[i][j] = val == false ? 0 : 1;
    // return val;
    // }
    // if (p.charAt(i - 1) == '*') {
    // boolean val = helper(p, s, i - 1, j) || helper(p, s, i, j - 1);
    // dp[i][j] = val == false ? 0 : 1;
    // return val;
    // }
    // dp[i][j] = 0;
    // return false;
    // }
}