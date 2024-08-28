class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid2[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean dfs(int grid1[][], int grid2[][], int r, int c) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        boolean isSubIsland = grid1[r][c] == 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (!isValid(nr, nc, grid1.length, grid2[0].length) || grid2[nr][nc] == 0)
                continue;
            grid2[nr][nc] = 0;
            isSubIsland &= dfs(grid1, grid2, nr, nc);
        }
        return isSubIsland;
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }
}