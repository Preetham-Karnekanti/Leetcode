class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[2] - a[2];
        });
        int ans = Integer.MAX_VALUE;
        pq.add(new int[] { 0, 0, grid[0][0] });
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int curMin = cur[2];
            ans = Math.min(ans, curMin);
            if (r == n - 1 && c == m - 1)
                break;
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, n, m) || vis[nr][nc])
                    continue;
                pq.add(new int[] { nr, nc, grid[nr][nc] });
                vis[nr][nc] = true;
            }
        }
        return ans;
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }
}