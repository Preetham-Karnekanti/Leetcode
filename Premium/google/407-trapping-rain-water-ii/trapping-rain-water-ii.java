class Solution {
    public int trapRainWater(int[][] heightMap) {
        int dx[] = new int[] { 1, -1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] vis = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    pq.add(new int[] { heightMap[i][j], i, j });
                    vis[i][j] = true;
                }
            }
        }
        int res = 0;
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int r = cur[1];
            int c = cur[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, rows, cols) || vis[nr][nc])
                    continue;
                vis[nr][nc] = true;
                if (heightMap[nr][nc] < cur[0]) {
                    res += (cur[0] - heightMap[nr][nc]);
                    heightMap[nr][nc] = cur[0];
                }
                pq.add(new int[] { heightMap[nr][nc], nr, nc });
            }
        }
        return res;
    }

    public boolean isValid(int i, int j, int r, int c) {
        if (i <= 0 || j <= 0 || i >= r - 1 || j >= c - 1)
            return false;
        return true;
    }
}