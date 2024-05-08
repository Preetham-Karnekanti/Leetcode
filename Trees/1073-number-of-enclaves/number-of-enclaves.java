class Solution {
    int dx[] = new int[] { -1, 1, 0, 0 };
    int dy[] = new int[] { 0, 0, -1, 1 };

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1)
                bfs(grid, i, 0);
            if (grid[i][cols - 1] == 1)
                bfs(grid, i, cols - 1);
        }
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 1)
                bfs(grid, 0, i);
            if (grid[rows - 1][i] == 1)
                bfs(grid, rows - 1, i);
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }
        return count;
    }

    public void bfs(int grid[][], int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        grid[r][c] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                if (!isValid(newX, newY, grid.length, grid[0].length) || grid[newX][newY] == 0)
                    continue;
                q.add(new int[] { newX, newY });
                grid[newX][newY] = 0;
            }
        }
    }

    public boolean isValid(int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols)
            return false;
        return true;
    }
}