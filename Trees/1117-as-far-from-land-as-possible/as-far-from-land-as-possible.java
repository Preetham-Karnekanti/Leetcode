class Solution {
    public int maxDistance(int[][] grid) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        Queue<int[]> q = new LinkedList<>();
        int step = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    q.add(new int[] { i, j });
            }
        }
        int steps = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            while (size-- > 0) {
                int cur[] = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (!isValid(nx, ny, grid.length, grid[0].length) || grid[nx][ny] == 1)
                        continue;
                    grid[nx][ny] = 1;
                    q.add(new int[] { nx, ny });
                }
            }
        }

        return steps == 0 ? -1 : steps;
    }

    public boolean isValid(int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols)
            return false;
        return true;
    }
}