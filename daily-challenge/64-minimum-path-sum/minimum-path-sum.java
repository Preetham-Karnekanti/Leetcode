class Solution {
    int dp[][];

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        return dfs(grid, 0, 0, grid.length, grid[0].length);
    }

    public int dfs(int grid[][], int r, int c, int n, int m) {
        if (!isValid(r, c, n, m))
            return (int) 1e9;
        if (r == n - 1 && c == m - 1)
            return grid[r][c];
        if (dp[r][c] != 0)
            return dp[r][c];
        return dp[r][c] = grid[r][c] + Math.min(dfs(grid, r + 1, c, n, m), dfs(grid, r, c + 1, n, m));
    }

    boolean isValid(int r, int c, int n, int m) {
        if (c >= m || r >= n)
            return false;
        return true;
    }
}