class Solution {
    int dp[][];

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 0; i < m; i++)
            min = Math.min(min, helper(matrix, 0, i));
        return min;
    }

    public int helper(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return (int) 1e9;
        if (i == grid.length - 1)
            return grid[i][j];
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        int s = grid[i][j] + helper(grid, i + 1, j);
        int ld = grid[i][j] + helper(grid, i + 1, j - 1);
        int rd = grid[i][j] + helper(grid, i + 1, j + 1);
        return dp[i][j] = Math.min(s, Math.min(ld, rd));
    }
}