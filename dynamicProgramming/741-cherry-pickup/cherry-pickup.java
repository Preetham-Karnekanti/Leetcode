class Solution {
    int dp[][][][];

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new int[n][n][n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    Arrays.fill(dp[i][j][k], -1);
        int ans = helper(grid, 0, 0, 0, 0, n);
        return ans <= 0 ? 0 : ans;
    }

    public int helper(int[][] grid, int i1, int j1, int i2, int j2, int n) {
        if (!isValid(i1, j1, n) || !isValid(i2, j2, n) || grid[i1][j1] == -1 || grid[i2][j2] == -1)
            return (int) -1e5;
        if (i1 == n - 1 && j1 == n - 1) {
            return grid[i1][j1];
        }
        if (dp[i1][j1][i2][j2] != -1)
            return dp[i1][j1][i2][j2];
        int max = 0;
        if (i1 == i2 && j1 == j2) {
            max += grid[i1][j1];
        } else {
            max += grid[i2][j2] + grid[i1][j1];
        }
        int one = helper(grid, i1 + 1, j1, i2 + 1, j2, n);
        int two = helper(grid, i1 + 1, j1, i2, j2 + 1, n);
        int three = helper(grid, i1, j1 + 1, i2 + 1, j2, n);
        int four = helper(grid, i1, j1 + 1, i2, j2 + 1, n);
        return dp[i1][j1][i2][j2] = max + Math.max(one, Math.max(two, Math.max(three, four)));
    }

    public boolean isValid(int i, int j, int n) {
        if (i < 0 || j < 0 || i >= n || j >= n)
            return false;
        return true;
    }
}