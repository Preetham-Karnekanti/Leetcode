class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int distance[][] = new int[m][n];
        String path[][] = new String[m][n];
        for (int i[] : distance)
            Arrays.fill(i, (int) 1e9);
        distance[ball[0]][ball[1]] = 0;
        path[ball[0]][ball[1]] = "";
        pq.add(new Node(ball[0], ball[1], 0));
        int[] dx = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        char dir[] = new char[] { 'u', 'd', 'l', 'r' };
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int r = cur.x;
            int c = cur.y;
            int distanceSoFar = cur.distance;
            for (int i = 0; i < 4; i++) {
                int nr = r;
                int nc = c;
                int steps = 0;
                while (isValid(nr + dx[i], nc + dy[i], m, n)
                        && maze[nr + dx[i]][nc + dy[i]] == 0
                        && !isHole(hole, nr, nc)) {
                    nr = nr + dx[i];
                    nc = nc + dy[i];
                    steps++;
                }
                if (steps + distanceSoFar <= distance[nr][nc]) {
                    String newPath = path[r][c] + dir[i];
                    if (steps + distanceSoFar == distance[nr][nc]) {
                        if (path[nr][nc].compareTo(newPath) > 0)
                            path[nr][nc] = newPath;
                    } else {
                        distance[nr][nc] = steps + distanceSoFar;
                        path[nr][nc] = newPath;
                        pq.add(new Node(nr, nc, distance[nr][nc]));
                    }
                }
            }
        }
        return path[hole[0]][hole[1]] == null ? "impossible" : path[hole[0]][hole[1]];
    }

    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return false;
        return true;
    }

    public boolean isHole(int hole[], int r, int c) {
        if (r == hole[0] && c == hole[1])
            return true;
        return false;
    }
}

class Node {
    int x, y;
    int distance;

    Node(int r, int c, int d) {
        x = r;
        y = c;
        distance = d;
    }
}