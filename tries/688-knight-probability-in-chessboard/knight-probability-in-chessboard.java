class Solution {
    int knightXMoves[] = new int[] { -2, -2, -1, +1, +2, +2, +1, -1 };
    int knightYMoves[] = new int[] { -1, +1, +2, +2, +1, -1, -2, -2 };

    public double knightProbability(int n, int k, int row, int column) {
        Double dp[][][] = new Double[n][n][k + 1];
        return helper(n, k, row, column, dp);
    }

    public double helper(int n, int k, int row, int col, Double dp[][][]) {
        if (!isValid(row, col, n))
            return 0.0;
        if (dp[row][col][k] != null)
            return dp[row][col][k];
        if (k == 0)
            return 1.0;
        double res = 0;
        for (int i = 0; i < 8; i++) {
            res = res + (1.0 / 8.0) * helper(n, k - 1, row + knightXMoves[i], col + knightYMoves[i], dp);
        }
        return dp[row][col][k] = res;
    }

    public boolean isValid(int r, int c, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n)
            return false;
        return true;
    }
}