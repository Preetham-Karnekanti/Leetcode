class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        Long dp[][][] = new Long[s.length()][3][4];
        return helper(s, 0, '2', 3, dp);
    }

    public long helper(String s, int idx, char prev, int length, Long dp[][][]) {
        if (length == 0)
            return 1;
        if (idx == s.length())
            return 0;
        if (dp[idx][prev - '0'][length] != null)
            return dp[idx][prev - 48][length];
        long ways = 0;
        if (prev == s.charAt(idx)) {
            ways = ways + helper(s, idx + 1, prev, length, dp);
        } else
            ways += helper(s, idx + 1, s.charAt(idx), length - 1, dp) + helper(s, idx + 1, prev, length, dp);
        return dp[idx][prev - 48][length] = ways;
    }
}