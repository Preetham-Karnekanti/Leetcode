class Solution {
    int dp[][];

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        dp = new int[n][m];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        int res = helper(dungeon, 0, 0);
        if (res == 0 && dungeon[0][0] < 0)
            res = dungeon[0][0];
        return res >= 0 ? 1 : -1 * res + 1;
    }

    public int helper(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i >= m || j >= n)
            return Integer.MIN_VALUE;
        if (i == m - 1 && j == n - 1)
            return grid[i][j] >= 0 ? 0 : grid[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = grid[i][j] + Math.max(helper(grid, i + 1, j), helper(grid, i, j + 1));
        return dp[i][j] = ans <= 0 ? ans : 0;
    }
}