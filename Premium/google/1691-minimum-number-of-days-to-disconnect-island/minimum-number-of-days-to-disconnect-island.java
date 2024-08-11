class Solution {
    int dx[] = new int[] { -1, 1, 0, 0 };
    int dy[] = new int[] { 0, 0, -1, 1 };

    public int minDays(int[][] grid) {
        int one = countIslands(grid);
        if (one > 1 || one == 0)
            return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int count = countIslands(grid);
                    if (count > 1 || count == 0)
                        return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public int countIslands(int grid[][]) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    dfs(vis, grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(boolean vis[][], int grid[][], int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        vis[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (!isValid(nr, nc, m, n) || vis[nr][nc] || grid[nr][nc] == 0)
                continue;
            dfs(vis, grid, nr, nc);
        }
    }

    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return false;
        return true;
    }
}