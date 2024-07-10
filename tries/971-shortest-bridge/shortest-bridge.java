class Solution {
    int dx[] = new int[] { -1, 1, 0, 0 };
    int dy[] = new int[] { 0, 0, -1, 1 };

    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        traverseFirstIsland(grid, q);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int k = 0; k < 4; k++) {
                    int nr = r + dx[k];
                    int nc = c + dy[k];
                    if (!isValid(nr, nc, grid) || grid[nr][nc] == -1)
                        continue;
                    if (grid[nr][nc] == 1)
                        return steps;
                    q.add(new int[] { nr, nc });
                    grid[nr][nc] = -1;
                }
            }
            steps++;
        }
        return steps;
    }

    public void traverseFirstIsland(int grid[][], Queue<int[]> q) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, q, i, j);
                    return;
                }
            }
        }
    }

    public void dfs(int grid[][], Queue<int[]> q, int i, int j) {
        q.add(new int[] { i, j });
        grid[i][j] = -1;
        for (int k = 0; k < 4; k++) {
            int nr = i + dx[k];
            int nc = j + dy[k];
            if (!isValid(nr, nc, grid) || grid[nr][nc] == 0 || grid[nr][nc] == -1)
                continue;
            dfs(grid, q, nr, nc);
        }
    }

    public boolean isValid(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return false;
        return true;
    }
}