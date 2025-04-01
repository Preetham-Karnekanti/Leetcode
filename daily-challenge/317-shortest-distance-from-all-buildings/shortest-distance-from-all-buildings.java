class Solution {
    public int shortestDistance(int[][] grid) {
        int totalHouses = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    totalHouses++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    min = Math.min(min, bfs(grid, i, j, totalHouses));
            }
        }

        return min == Integer.MAX_VALUE || min == 0 ? -1 : min;
    }

    public int bfs(int grid[][], int row, int col, int totalHouses) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid[0].length;
        int m = grid.length;
        boolean vis[][] = new boolean[m][n];
        vis[row][col] = true;
        int distance = 0;
        int housesVisited = 0;
        q.add(new int[] { row, col, 0 });
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty() && totalHouses != housesVisited) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            int movesMade = cur[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, m, n) || grid[nr][nc] == 2 || vis[nr][nc])
                    continue;
                if (grid[nr][nc] == 1) {
                    distance += movesMade + 1;
                    housesVisited++;
                    vis[nr][nc] = true;
                } else if (grid[nr][nc] == 0) {
                    q.add(new int[] { nr, nc, movesMade + 1 });
                    vis[nr][nc] = true;
                }
            }
        }
        if (totalHouses != housesVisited)
            return Integer.MAX_VALUE;
        return distance;
    }

    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return false;
        return true;
    }
}