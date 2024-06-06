class Solution {
    Integer dp[][][][];
    int m = (int) 1e9 + 7;

    public int countPalindromes(String s) {
        dp = new Integer[s.length()][10][10][5];
        return helper(s, 0, 0, 0, 0);
    }

    public int helper(String s, int first, int second, int idx, int length) {
        if (length == 5)
            return 1;
        if (idx == s.length())
            return 0;
        if (dp[idx][first][second][length] != null)
            return dp[idx][first][second][length];
        int pick = 0;
        if (length == 0) {
            pick = helper(s, s.charAt(idx) - '0', second, idx + 1, length + 1);
        } else if (length == 1) {
            pick = helper(s, first, s.charAt(idx) - '0', idx + 1, length + 1);
        } else if (length == 2)
            pick = helper(s, first, second, idx + 1, length + 1);
        else if (length == 3 && second == s.charAt(idx) - '0') {
            pick = helper(s, first, second, idx + 1, length + 1);
        } else if (length == 4 && first == s.charAt(idx) - '0') {
            pick = helper(s, first, second, idx + 1, length + 1);
        }
        int exclude = helper(s, first, second, idx + 1, length);
        return dp[idx][first][second][length] = (pick + exclude) % m;
    }
}