class Solution {
    public int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
         if (grid[1][0] > 1 && grid[0][1] > 1)  return -1;
        int visited[][] = new int[n][m];
        for (int i[] : visited)
            Arrays.fill(i, (int) 1e9);

        visited[0][0] = 0;
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int time = cur[2];
            if (r == n - 1 && c == m - 1) {
                return time;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (isValid(nr, nc, n, m)) {
                    int wt = ((grid[nr][nc] - time) % 2 == 1) ? 0 : 1;
                    int ntime = Math.max(time + 1, grid[nr][nc] + wt);

                    if (ntime < visited[nr][nc]) {
                        visited[nr][nc] = ntime;
                        pq.add(new int[] { nr, nc, ntime });
                    }
                }
            }
        }
        return -1;
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }
}