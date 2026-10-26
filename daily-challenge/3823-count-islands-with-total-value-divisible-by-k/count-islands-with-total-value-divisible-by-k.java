class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    long sum = bfs(grid, i, j);
                    if (sum % k == 0)
                        ans++;
                }
            }
        }
        return ans;
    }

    public long bfs(int grid[][], int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        int dr[] = new int[] { -1, 1, 0, 0 };
        int dc[] = new int[] { 0, 0, -1, 1 };
        long sum = grid[row][col];
        q.add(new int[] { row, col });
        grid[row][col] = 0;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] == 0)
                    continue;
                sum += grid[nr][nc];
                grid[nr][nc] = 0;
                q.add(new int[] { nr, nc });
            }
        }
        return sum;
    }
}