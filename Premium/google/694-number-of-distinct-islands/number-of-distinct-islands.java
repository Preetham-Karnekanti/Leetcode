class Solution {
    int dx[] = new int[] { -1, 1, 0, 0 };
    int dy[] = new int[] { 0, 0, -1, 1 };

    public int numDistinctIslands(int[][] grid) {
        HashSet<ArrayList<String>> hs = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ArrayList<String> temp = new ArrayList<>();
                    bfs(temp, grid, i, j);
                    hs.add(temp);
                }
            }
        }
        return hs.size();
    }

    public void bfs(ArrayList<String> temp, int[][] grid, int x, int y) {
        grid[x][y] = 0;
        temp.add("" + 0 + ":" + 0);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y });
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + r;
                int nc = dy[i] + c;
                if (!isValid(nr, nc, grid))
                    continue;
                int tX = nr - x;
                int tY = nc - y;
                temp.add(tX + ":" + tY);
                q.add(new int[] { nr, nc });
                grid[nr][nc] = 0;
            }
        }
    }

    public boolean isValid(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
            return false;
        return true;
    }
}