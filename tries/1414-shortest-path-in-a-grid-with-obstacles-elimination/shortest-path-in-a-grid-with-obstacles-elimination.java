class Solution {
    public int shortestPath(int[][] grid, int k) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        int steps = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][][] = new boolean[m][n][k + 1];
        q.add(new int[] { 0, 0, k });
        vis[0][0][k] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];
                int remaining = cur[2];
                if (r == m - 1 && c == n - 1)
                    return steps;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    if (!isValid(nr, nc, m, n) || vis[nr][nc][remaining] == true)
                        continue;
                    if (grid[nr][nc] == 1 && remaining > 0) {
                        q.add(new int[] { nr, nc, remaining - 1 });
                        vis[nr][nc][remaining] = true;
                    } else if (grid[nr][nc] == 0) {
                        q.add(new int[] { nr, nc, remaining });
                        vis[nr][nc][remaining] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return false;
        return true;
    }
}