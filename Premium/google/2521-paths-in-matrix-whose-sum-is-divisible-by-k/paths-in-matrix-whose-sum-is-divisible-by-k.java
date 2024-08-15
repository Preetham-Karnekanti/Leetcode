class Solution {
    int mod = (int) 1e9 + 7;

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Integer dp[][][] = new Integer[n][m][k];
        return helper(grid, 0, 0, 0, k, dp);
    }

    public int helper(int[][] grid, int i, int j, int sum, int k, Integer[][][] dp) {
        if (i >= grid.length || j >= grid[0].length)
            return 0;
        if (dp[i][j][sum % k] != null)
            return dp[i][j][sum % k];
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return (sum + grid[i][j]) % k == 0 ? 1 : 0;
        }
        int right = helper(grid, i, j + 1, sum + grid[i][j], k, dp);
        int down = helper(grid, i + 1, j, sum + grid[i][j], k, dp);
        return dp[i][j][sum % k] = (right + down) % mod;
    }
}