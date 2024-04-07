class Solution {
    String s;
    Boolean[][] dp;

    public boolean checkValidString(String s) {
        this.s = s;
        this.dp = new Boolean[s.length() + 1][s.length() + 1];
        return helper(0, 0);
    }

    public boolean helper(int i, int open) {
        if (i == s.length()) {
            if (open == 0)
                return true;
            return false;
        }
        int j = open >= 0 ? open : 0;
        if (dp[i][j] != null)
            return dp[i][j];
        if (open < 0)
            return dp[i][j] = false;
        if (s.charAt(i) == '(') {
            return dp[i][j] = helper(i + 1, open + 1);
        } else if (s.charAt(i) == ')') {
            if (open > 0) {
                return dp[i][j] = helper(i + 1, open - 1);
            } else {
                return dp[i][j] = false;
            }
        } else {
            return dp[i][j] = helper(i + 1, open) || helper(i + 1, open + 1) || helper(i + 1, open - 1);
        }
    }
}