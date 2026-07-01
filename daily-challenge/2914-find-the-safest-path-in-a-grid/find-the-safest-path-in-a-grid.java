class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
            return 0;
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        int distance[][] = getDistanaceMatrix(grid);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[] { 0, 0, distance[0][0] });
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int minSoFar = cur[2];
            if (r == n - 1 && c == n - 1)
                return minSoFar;
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, n) || grid.get(nr).get(nc) == 1)
                    continue;
                int min = Math.min(minSoFar, distance[nr][nc]);
                pq.add(new int[] { nr, nc, min });
                grid.get(nr).set(nc, 1);
            }
        }
        return 0;
    }

    public int[][] getDistanaceMatrix(List<List<Integer>> grid) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        Queue<int[]> q = new LinkedList<>();
        int n = grid.size();
        int distance[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], (int) 1e9);
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[] { i, j, 0 });
                    distance[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            int distanceSoFar = cur[2];
            for (int k = 0; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];
                if (!isValid(nr, nc, n) || grid.get(nr).get(nc) == 1)
                    continue;
                if (1 + distanceSoFar < distance[nr][nc]) {
                    distance[nr][nc] = 1 + distanceSoFar;
                    q.add(new int[] { nr, nc, 1 + distanceSoFar });
                }
            }
        }
        return distance;
    }

    public boolean isValid(int r, int c, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n)
            return false;
        return true;
    }
}