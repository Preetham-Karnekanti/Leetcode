class Solution {
    int dp[][];

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(s1, s2, s3, 0, 0);
    }

    public boolean helper(String s1, String s2, String s3, int i, int j) {
        if (i + j == s3.length())
            return true;
        if (dp[i][j] != -1)
            return dp[i][j] == 0 ? false : true;
        boolean one = false;
        boolean two = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
            one = helper(s1, s2, s3, i + 1, j);
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
            two = helper(s1, s2, s3, i, j + 1);
        dp[i][j] = (two || one) == true ? 1 : 0;
        return two || one;
    }
}