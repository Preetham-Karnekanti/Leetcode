class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int x = s1.length();
        int y = s2.length();
        int z = s3.length();
        if (x + y != z) {
            return false;
        }
        // Table Creation
        boolean dp[][] = new boolean[x + 1][y + 1];
        dp[0][0] = true;

        // Base Case Initialization
        for (int i = 1; i <= x; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else
                break;
        }

        for (int j = 1; j <= y; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = true;
            } else
                break;
        }

        // Fill - Bottom Up
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (!dp[i][j] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                }
                // !dp[i][j] : so that i will go for 2nd condition only if 1st if statement
                // doesn't satisfy the conditons.
            }
        }
        return dp[x][y];
    }
}