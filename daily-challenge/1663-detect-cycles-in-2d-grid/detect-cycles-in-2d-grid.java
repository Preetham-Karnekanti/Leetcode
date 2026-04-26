class Solution {
    public boolean containsCycle(char[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && bfs(grid, i, j, vis))
                    return true;
            }
        }
        return false;
    }

    public boolean bfs(char grid[][], int i, int j, boolean vis[][]) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        char ch = grid[i][j];
        Queue<int[]> q = new LinkedList<>();
        vis[i][j] = true;
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
                if (!isValid(nr, nc, grid) || grid[nr][nc] != ch)
                    continue;
                if (pr == nr && pc == nc)
                    continue;
                if (vis[nr][nc])
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