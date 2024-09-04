class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        int steps = 0;
        maze[entrance[0]][entrance[1]] = '+';
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    if (!isValid(nr, nc, maze.length, maze[0].length) || maze[nr][nc] == '+')
                        continue;
                    if (nr == 0 || nc == 0 || nr == maze.length - 1 || nc == maze[0].length - 1)
                        return steps + 1;
                    q.add(new int[] { nr, nc });
                    maze[nr][nc] = '+';
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