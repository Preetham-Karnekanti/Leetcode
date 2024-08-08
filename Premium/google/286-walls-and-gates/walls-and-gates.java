class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0)
                    q.add(new int[] { i, j, 0 });
            }
        }
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            int distanceSoFar = cur[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, m, n))
                    continue;
                if (1 + distanceSoFar < rooms[nr][nc]) {
                    q.add(new int[] { nr, nc, 1 + distanceSoFar });
                    rooms[nr][nc] = distanceSoFar + 1;
                }
            }
        }
    }

    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return false;
        return true;
    }
}