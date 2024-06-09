class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        grid[0][0] = 1;
        int rows = grid.length;
        int cols = grid[0].length;
        int dx[] = new int[] { -1, 1, 0, 0, -1, -1, 1, 1 };
        int dy[] = new int[] { 0, 0, 1, -1, -1, 1, -1, 1 };
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];
                if (r == rows - 1 && c == cols - 1)
                    return steps;
                for (int i = 0; i < 8; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    if (!isValid(nr, nc, rows, cols) || grid[nr][nc] == 1)
                        continue;
                    q.add(new int[] { nr, nc });
                    grid[nr][nc] = 1;
                }
            }
            steps++;
        }
        return -1;
    }

    public boolean isValid(int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c)
            return false;
        return true;
    }
}