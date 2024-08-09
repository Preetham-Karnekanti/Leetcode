class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        int n = maze.length;
        int m = maze[0].length;
        int distance[][] = new int[n][m];
        for (int i[] : distance)
            Arrays.fill(i, (int) 1e9);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start[0], start[1], 0 });
        distance[start[0]][start[1]] = 0;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            int distanceSoFar = cur[2];
            for (int i = 0; i < 4; i++) {
                int nr = r;
                int nc = c;
                int steps = 0;
                while (isValid(nr + dx[i], nc + dy[i], n, m) && maze[nr + dx[i]][nc + dy[i]] == 0) {
                    nr = nr + dx[i];
                    nc = nc + dy[i];
                    steps++;
                }
                if (distanceSoFar + steps < distance[nr][nc]) {
                    q.add(new int[] { nr, nc, distanceSoFar + steps });
                    distance[nr][nc] = distanceSoFar + steps;
                }
            }
        }
        int x = destination[0];
        int y = destination[1];
        return distance[x][y] == (int)1e9 ? -1 : distance[x][y];
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }
}