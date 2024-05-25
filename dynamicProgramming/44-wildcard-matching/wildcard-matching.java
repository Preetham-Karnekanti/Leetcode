class Solution {
    int dp[][];

    public boolean isMatch(String s, String p) {
        dp = new int[p.length()][s.length()];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(p, s, p.length()-1, s.length()-1);
    }

    public boolean helper(String p, String s, int i, int j) {
        if (i < 0 && j < 0)
            return true;
        if (i < 0 && j >= 0)
            return false;
        if (j < 0 && i >= 0) {
            for (int ii = 0; ii <= i; ii++)
                if (p.charAt(ii) != '*')
                    return false;
            return true;
        }
        if (dp[i][j] != -1)
            return dp[i][j] == 0 ? false : true;
        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
            boolean val = helper(p, s, i - 1, j - 1);
            dp[i][j] = val == false ? 0 : 1;
            return val;
        }
        if (p.charAt(i) == '*') {
            boolean val = helper(p, s, i - 1, j) || helper(p, s, i, j - 1);
            dp[i][j] = val == false ? 0 : 1;
            return val;
        }
        dp[i][j] = 0;
        return false;
    }
}