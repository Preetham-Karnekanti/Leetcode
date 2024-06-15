class Solution {
    public int findMaxFish(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    int ans = bfs(grid, i, j);
                    max = Math.max(max, ans);
                }
            }
        }
        return max;
    }

    public int bfs(int grid[][], int i, int j) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        int total = grid[i][j];
        grid[i][j] = 0;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];
                if (!isValid(nr, nc, grid) || grid[nr][nc] == 0)
                    continue;
                total += grid[nr][nc];
                grid[nr][nc] = 0;
                q.add(new int[] { nr, nc });
            }
        }
        return total;
    }

    public boolean isValid(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return false;
        return true;
    }
}