class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean pacific[][] = new boolean[rows][cols];
        boolean atlantic[][] = new boolean[rows][cols];
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            q1.add(new int[] { i, 0 });
            pacific[i][0] = true;
        }
        for (int i = 1; i < cols; i++) {
            pacific[0][i] = true;
            q1.add(new int[] { 0, i });
        }
        bfs(heights, pacific, q1);
        for (int i = 0; i < rows; i++) {
            q2.add(new int[] { i, cols - 1 });
            atlantic[i][cols - 1] = true;
        }
        for (int i = 0; i < cols; i++) {
            q2.add(new int[] { rows - 1, i });
            atlantic[rows - 1][i] = true;
        }
        bfs(heights, atlantic, q2);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return ans;
    }

    public void bfs(int grid[][], boolean vis[][], Queue<int[]> q) {
        int rows = grid.length, cols = grid[0].length;
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + r;
                int nc = dy[i] + c;
                if (!isValid(nr, nc, rows, cols) || vis[nr][nc])
                    continue;
                if (grid[nr][nc] >= grid[r][c]) {
                    System.out.println(nr + " " + nc);
                    vis[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }
    }

    public boolean isValid(int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols)
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
