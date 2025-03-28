class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int answer[] = new int[queries.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> queries[a] - queries[b]);
        PriorityQueue<int[]> bfsQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < queries.length; i++)
            pq.add(i);
        bfsQueue.add(new int[] { grid[0][0], 0, 0 });
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        vis[0][0] = true;
        int points = 0;
        int dx[] = new int[] { 0, 0, -1, 1 };
        int dy[] = new int[] { -1, 1, 0, 0 };
        while (!pq.isEmpty()) {
            int curIdx = pq.poll();
            int value = queries[curIdx];
            while (!bfsQueue.isEmpty() && bfsQueue.peek()[0] < value) {
                int cur[] = bfsQueue.poll();
                int cell = cur[0];
                int r = cur[1];
                int c = cur[2];
                points++;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    if (!isValid(nr, nc, grid) || vis[nr][nc])
                        continue;
                    bfsQueue.add(new int[] { grid[nr][nc], nr, nc });
                    vis[nr][nc] = true;
                }
            }
            answer[curIdx] = points;
        }
        return answer;
    }

    public boolean isValid(int r, int c, int grid[][]) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return false;
        return true;
    }
}