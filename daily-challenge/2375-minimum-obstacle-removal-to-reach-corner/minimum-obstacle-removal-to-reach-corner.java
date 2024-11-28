class Solution {
    public int minimumObstacles(int[][] grid) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = grid.length;
        int m = grid[0].length;
        int removals[][] = new int[n][m];
        for (int i[] : removals)
            Arrays.fill(i, (int) 1e9);
        removals[0][0] = 0;
        pq.add(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int removed = cur[0];
            int r = cur[1];
            int c = cur[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, n, m))
                    continue;
                if (removals[nr][nc] > grid[nr][nc] + removed) {
                    removals[nr][nc] = grid[nr][nc] + removed;
                    pq.add(new int[] { removals[nr][nc], nr, nc });
                }
            }
        }
        return removals[n - 1][m - 1];
    }

    public boolean isValid(int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c)
            return false;
        return true;
    }
}