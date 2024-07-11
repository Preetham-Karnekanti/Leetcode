class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (maze[i][0] == '.') {
                if (entrance[0] == i && entrance[1] == 0)
                    continue;
                q.add(new int[] { i, 0 });
                vis[i][0] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (maze[i][m - 1] == '.') {
                if (entrance[0] == i && entrance[1] == m - 1)
                    continue;
                vis[i][m - 1] = true;
                q.add(new int[] { i, m - 1 });
            }
        }

        for (int i = 1; i < m - 1; i++) {
            if (maze[0][i] == '.') {
                if (entrance[0] == 0 && entrance[1] == i)
                    continue;
                q.add(new int[] { 0, i });
                vis[0][i] = true;
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (maze[n - 1][i] == '.') {
                if (entrance[0] == n - 1 && entrance[1] == i)
                    continue;
                q.add(new int[] { n - 1, i });
                vis[n - 1][i] = true;
            }
        }
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int k = 0; k < 4; k++) {
                    int nr = r + dx[k];
                    int nc = c + dy[k];
                    if (!isValid(nr, nc, n, m) || vis[nr][nc] || maze[nr][nc] == '+')
                        continue;
                    if (nr == entrance[0] && nc == entrance[1])
                        return steps + 1;
                    vis[nr][nc] = true;
                    q.add(new int[] { nr, nc });
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