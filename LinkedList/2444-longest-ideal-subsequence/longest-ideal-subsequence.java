class Solution {
    private int solve(String s, int idx, int k, int[][] dp, char ch) {
        if (idx >= s.length()) {
            return 0;
        }
        if (dp[idx][ch] != -1)
            return dp[idx][ch];
        int take = 0;
        int nottake = 0;
        if (Math.abs(ch - s.charAt(idx)) <= k || ch == '#')
            take = 1 + solve(s, idx + 1, k, dp, s.charAt(idx));
        nottake = solve(s, idx + 1, k, dp, ch);
        return dp[idx][ch] = Math.max(take, nottake);
    }

    public int longestIdealString(String s, int k) {
        int[][] dp = new int[s.length() + 1][130];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solve(s, 0, k, dp, '#');
    }

}
