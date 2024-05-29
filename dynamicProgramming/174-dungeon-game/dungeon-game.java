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

    public int helper(int grid[][], int i, int j) {
        if (!isValid(i, j, grid))
            return Integer.MIN_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j] >= 0 ? 0 : grid[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = grid[i][j] + Math.max(helper(grid, i + 1, j), helper(grid, i, j + 1));
        return dp[i][j] = ans <= 0 ? ans : 0;
    }

    public boolean isValid(int r, int c, int grid[][]) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return false;
        return true;
    }
}