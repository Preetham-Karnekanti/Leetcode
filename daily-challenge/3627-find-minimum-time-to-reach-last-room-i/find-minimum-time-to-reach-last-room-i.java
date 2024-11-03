class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] { 0, 0, 0 });
        int n = moveTime.length;
        int m = moveTime[0].length;
        int vis[][] = new int[n][m];
        for (int i[] : vis)
            Arrays.fill(i, Integer.MAX_VALUE);
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        vis[0][0] = 0;
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int timeSoFar = cur[2];

            if (r == n - 1 && c == m - 1)
                return timeSoFar;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, n, m))
                    continue;
                int waitTime = Math.max(moveTime[nr][nc] - timeSoFar, 0);
                int newTime = 1 + waitTime + timeSoFar;
                if (newTime >= vis[nr][nc])
                    continue;
                pq.add(new int[] { nr, nc, 1 + waitTime + timeSoFar });
                vis[nr][nc] = 1 + waitTime + timeSoFar;
            }
        }
        return vis[n - 1][m - 1];
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }
}