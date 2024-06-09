class Solution {
    public int minimumEffortPath(int[][] heights) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        int rows = heights.length, cols = heights[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] dist = new int[rows][cols];
        for (int i[] : dist)
            Arrays.fill(i, Integer.MAX_VALUE);
        dist[0][0] = 0;
        q.add(new int[] { 0, 0, 0 });
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int distance = cur[0];
            int r = cur[1];
            int c = cur[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, rows, cols))
                    continue;
                int diff = Math.max(Math.abs(heights[r][c] - heights[nr][nc]), distance);
                if (dist[nr][nc] > diff) {
                    dist[nr][nc] = diff;
                    q.add(new int[] { diff, nr, nc });
                }
            }
        }

        return dist[rows - 1][cols - 1];
    }

    public boolean isValid(int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || c >= cols || r >= rows)
            return false;
        return true;
    }
}