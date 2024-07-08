class Solution {
    public int maxMoves(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(grid, i, 0, dp));
        }
        return max;
    }

    public int dfs(int grid[][], int i, int j, int[][] dp) {
        int n = grid.length;
        int m = grid[0].length;
        int dx[] = new int[] { -1, 0, 1 };
        int dy[] = new int[] { 1, 1, 1 };
        int max = 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        for (int k = 0; k < 3; k++) {
            int nr = i + dx[k];
            int nc = j + dy[k];
            if (!isValid(nr, nc, n, m) || grid[nr][nc] <= grid[i][j])
                continue;
            max = Math.max(max, 1 + dfs(grid, nr, nc, dp));
        }
        return dp[i][j] = max;
    }

    public boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || j >= m || i >= n)
            return false;
        return true;
    }
}