class Solution {
    public int longestPalindromeSubseq(String s1) {
        int dp[][] = new int[s1.length() + 1][s1.length() + 1];
        StringBuilder s2 = new StringBuilder(s1).reverse();
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s1.length(); j++) {
                if (i == 0 || j == 0)
                    continue;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s1.length()];
    }
}