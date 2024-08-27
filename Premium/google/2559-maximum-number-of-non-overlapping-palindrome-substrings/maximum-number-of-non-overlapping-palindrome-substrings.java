class Solution {
    Boolean isPallindromeDp[][];

    public int maxPalindromes(String s, int k) {
        int dp[] = new int[s.length()];
        isPallindromeDp = new Boolean[s.length() + 1][s.length() + 1];
        Arrays.fill(dp, -1);
        return helper(s, 0, k, dp);
    }

    public int helper(String s, int idx, int minLength, int dp[]) {
        if (idx >= s.length())
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int max = 0;
        max = Math.max(max, helper(s, idx + 1, minLength, dp));
        for (int i = idx + minLength - 1; i < s.length(); i++) {
            if (isPallindrome(s, idx, i)) {
                max = Math.max(max, 1 + helper(s, i + 1, minLength, dp));
            }
        }
        return dp[idx] = max;
    }

    public boolean isPallindrome(String str, int i, int j) {
        if (i >= j)
            return true;

        if (isPallindromeDp[i][j] != null)
            return isPallindromeDp[i][j];

        if (str.charAt(i) == str.charAt(j))
            return isPallindromeDp[i][j] = isPallindrome(str, i + 1, j - 1);
        else
            return isPallindromeDp[i][j] = false;
    }
}