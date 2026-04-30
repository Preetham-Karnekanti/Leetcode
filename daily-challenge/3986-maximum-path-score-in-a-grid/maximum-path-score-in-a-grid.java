class Solution {
    Integer dp[][][];
    public int maxPathScore(int[][] grid, int k) {
        dp = new Integer[grid.length][grid[0].length][k + 1];
        int ans = helper(grid, 0, 0, k);
        return ans < 0 ? -1 : ans;
    }

    public int helper(int grid[][], int i, int j, int k) {
        if (i >= grid.length || j >= grid[0].length)
            return -(int) 1e9;
        if (k < 0)
            return -(int) 1e9;
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            int cost = grid[i][j] == 2 ? 1 : grid[i][j];
            if (k >= cost) {
                return grid[i][j];
            }
            return -(int) 1e9;
        }
        if(dp[i][j][k] != null)
            return dp[i][j][k];
        int cost = grid[i][j] == 2 ? 1 : grid[i][j];
        return dp[i][j][k] = grid[i][j] + Math.max(helper(grid, i + 1, j, k - cost), helper(grid, i, j + 1, k - cost));
    }
}