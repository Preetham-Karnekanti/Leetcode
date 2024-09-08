class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();
        boolean pvis[][] = new boolean[n][m];
        boolean avis[][] = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            pq.add(new int[] { 0, i });
            pvis[0][i] = true;
            aq.add(new int[] { n - 1, i });
            avis[n - 1][i] = true;
        }
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { i, 0 });
            pvis[i][0] = true;
            aq.add(new int[] { i, m - 1 });
            avis[i][m - 1] = true;
        }
        bfs(heights, pq, pvis);
        bfs(heights, aq, avis);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pvis[i][j] && avis[i][j])
                    answer.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return answer;
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }

    public void bfs(int[][] heights, Queue<int[]> q, boolean vis[][]) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, heights.length, heights[0].length) || vis[nr][nc])
                    continue;
                if (heights[nr][nc] >= heights[r][c]) {
                    q.add(new int[] { nr, nc });
                    vis[nr][nc] = true;
                }
            }
        }
    }
}