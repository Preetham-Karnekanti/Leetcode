class Solution {
    int dx[] = new int[] { -1, 1, 0, 0 };
    int dy[] = new int[] { 0, 0, -1, 1 };

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    int sum = dfs(grid, i, j, m, n);
                    if (sum % k == 0)
                        ans++;
                }
            }
        }
        return ans;
    }

    public int dfs(int grid[][], int r, int c, int m, int n) {
        int sum = grid[r][c];
        grid[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (!isValid(nr, nc, m, n) || grid[nr][nc] == 0)
                continue;
            sum += dfs(grid, nr, nc, m, n);
        }
        return sum;
    }

    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return false;
        return true;
    }
}