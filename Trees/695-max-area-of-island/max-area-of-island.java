class Solution {
    int dx[] = new int[] { -1, 0, 1, 0 };
    int dy[] = new int[] { 0, -1, 0, 1 };

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    max = Math.max(max, bfs(grid, i, j));
            }
        }
        return max;
    }

    public int bfs(int grid[][], int r, int c) {
        int count = 1;
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
                count++;
                grid[newX][newY] = 0;
                q.add(new int[] { newX, newY });
            }
        }
        return count;
    }

    public boolean isValid(int r, int c, int row, int col) {
        if (r < 0 || c < 0 || r >= row || c >= col)
            return false;
        return true;
    }
}