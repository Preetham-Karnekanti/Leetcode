class Solution {
    public int orangesRotting(int[][] grid) {
        int dx[] = new int[] { 1, -1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                    grid[i][j] = 0;
                }
            }
        }
        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur[] = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = cur[0] + dx[i];
                    int nc = cur[1] + dy[i];
                    if (!isValid(grid, nr, nc) || grid[nr][nc] == 0)
                        continue;
                    q.add(new int[] { nr, nc });
                    grid[nr][nc] = 0;
                }
            }
            time++;
        }
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] != 0)
                    return -1;
        return time == -1 ? 0 : time;
    }

    public boolean isValid(int grid[][], int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return false;
        return true;
    }
}