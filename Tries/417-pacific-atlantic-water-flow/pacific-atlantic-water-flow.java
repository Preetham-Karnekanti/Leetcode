class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean pacific[][] = new boolean[n][m];
        Queue<int[]> q1 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q1.add(new int[] { i, 0 });
            pacific[i][0] = true;
        }
        for (int i = 1; i < m; i++) {
            pacific[0][i] = true;
            q1.add(new int[] { 0, i });
        }
        bfs(heights, pacific, q1);

        boolean atlantic[][] = new boolean[n][m];
        Queue<int[]> q2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q2.add(new int[] { i, m - 1 });
            atlantic[i][m - 1] = true;
        }
        for (int i = 0; i < m - 1; i++) {
            q2.add(new int[] { n - 1, i });
            atlantic[n - 1][i] = true;
        }
        bfs(heights, atlantic, q2);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return ans;
    }

    public void bfs(int grid[][], boolean vis[][], Queue<int[]> q) {
        int n = grid.length, m = grid[0].length;
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + r;
                int nc = dy[i] + c;
                if(!isValid(nr, nc, n, m) || vis[nr][nc] || grid[nr][nc] < grid[r][c])
                    continue;
                vis[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }
}

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
