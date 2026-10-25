class Solution {
    int rows, cols;
    int[] dx = new int[] { -1, 1, 0, 0 };
    int[] dy = new int[] { 0, 0, -1, 1 };

    public int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && i != 0 && j != 0 && i != rows - 1 && j != cols - 1)
                    if (bfs(grid, i, j))
                        count++;
            }
        }
        return count;
    }

    public boolean bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        grid[r][c] = 1;
        boolean isClosed = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                if (!isValid(newX, newY) || grid[newX][newY] == 1)
                    continue;
                if (newX == 0 || newY == 0 || newX == rows - 1 || newY == cols - 1)
                    isClosed = false;
                q.add(new int[] { newX, newY });
                grid[newX][newY] = 1;
            }
        }
        return isClosed;
    }

    public boolean isValid(int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols)
            return false;
        return true;
    }
}