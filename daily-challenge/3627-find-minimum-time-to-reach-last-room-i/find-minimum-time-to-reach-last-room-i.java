class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] { 0, 0, 0 });
        int n = moveTime.length;
        int m = moveTime[0].length;
        int vis[][] = new int[n][m];
        for (int i[] : vis)
            Arrays.fill(i, Integer.MAX_VALUE);
       int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        vis[0][0] = 0;
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int timeSoFar = cur[2];

            if (x == n - 1 && y == m - 1)
                return timeSoFar;

            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    int waitTime = Math.max(moveTime[newX][newY] - timeSoFar, 0);
                    int newTime = timeSoFar + 1 + waitTime;

                    if (newTime < vis[newX][newY]) {
                        vis[newX][newY] = newTime;
                        pq.offer(new int[]{ newX, newY, newTime});
                    }
                }
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