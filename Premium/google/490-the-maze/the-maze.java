class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        q.add(start);
        boolean vis[][] = new boolean[m][n];
        vis[start[0]][start[1]] = true;
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            if (Arrays.equals(cur, destination))
                return true;
            for (int i = 0; i < 4; i++) {
                int nr = r;
                int nc = c;
                while (isValid(nr + dx[i], nc + dy[i], m, n) == true
                        && maze[nr + dx[i]][nc + dy[i]] == 0) {
                    nr = nr + dx[i];
                    nc = nc + dy[i];
                }
                if (vis[nr][nc])
                    continue;
                q.add(new int[] { nr, nc });
                vis[nr][nc] = true;
            }
        }
        return false;
    }

    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return false;
        return true;
    }
}