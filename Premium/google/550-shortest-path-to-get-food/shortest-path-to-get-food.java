class Solution {
    public int getFood(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    q.add(new int[] { i, j });
                    vis[i][j] = true;
                    break;
                }
            }
        }
        int steps = 0;
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    if (!isValid(nr, nc, n, m) || grid[nr][nc] == 'X' || vis[nr][nc])
                        continue;
                    if (grid[nr][nc] == '#')
                        return steps + 1;
                    q.add(new int[] { nr, nc, 1 + steps });
                    vis[nr][nc] = true;
                }
            }
            steps++;
        }
        return -1;
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }
}