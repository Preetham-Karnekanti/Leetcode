class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && bfs(i, j, grid, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bfs(int i, int j, char grid[][], boolean vis[][]) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        vis[i][j] = true;
        char ch = grid[i][j];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j, -1, -1 });
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            int pr = cur[2];
            int pc = cur[3];
            for (int k = 0; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];
                if (nr == pr && nc == pc)
                    continue;
                if (!isValid(nr, nc, grid) || grid[nr][nc] != ch)
                    continue;
                if (vis[nr][nc] && grid[nr][nc] == ch)
                    return true;
                vis[nr][nc] = true;
                q.add(new int[] { nr, nc, r, c });
            }
        }
        return false;
    }

    public boolean isValid(int r, int c, char grid[][]) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return false;
        return true;
    }
}