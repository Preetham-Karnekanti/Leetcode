class Solution {
    int mod = (int) 1e9 + 7;
    Integer dp[][][];

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Integer[m][n][maxMove + 1];
        return helper(m, n, maxMove, startRow, startColumn);
    }

    public int helper(int m, int n, int maxMoves, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 1;
        if (maxMoves <= 0)
            return 0;
        if (dp[i][j][maxMoves] != null)
            return dp[i][j][maxMoves];
        int count = 0;
        count = (count + helper(m, n, maxMoves - 1, i - 1, j)) % mod;
        count = (count + helper(m, n, maxMoves - 1, i + 1, j)) % mod;
        count = (count + helper(m, n, maxMoves - 1, i, j - 1)) % mod;
        count = (count + helper(m, n, maxMoves - 1, i, j + 1)) % mod;
        return dp[i][j][maxMoves] = count;
    }
}