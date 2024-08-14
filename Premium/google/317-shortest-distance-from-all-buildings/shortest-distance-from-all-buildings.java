class Solution {
    public int shortestDistance(int[][] grid) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    minDistance = Math.min(minDistance, getDistanceToAllBuildings(grid, i, j));
                }
            }
        }
        return minDistance == Integer.MAX_VALUE || minDistance == 0 ? -1 : minDistance;
    }

    public int getDistanceToAllBuildings(int grid[][], int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];
        vis[i][j] = true;
        int distanceTravelled = 0;
        int movesMade = 0;
        q.add(new int[] { i, j });
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];
                if (grid[r][c] == 1) {
                    distanceTravelled += movesMade;
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nr = r + dx[k];
                    int nc = c + dy[k];
                    if (!isValid(nr, nc, m, n) || grid[nr][nc] == 2 || vis[nr][nc])
                        continue;
                    q.add(new int[] { nr, nc });
                    vis[nr][nc] = true;
                }
            }
            movesMade++;
        }
        for (int l = 0; l < m; l++) {
            for (int k = 0; k < n; k++) {
                if (grid[l][k] == 1 && !vis[l][k]) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return distanceTravelled;
    }

    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return false;
        return true;
    }
}