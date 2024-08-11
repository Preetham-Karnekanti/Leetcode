class Solution {
    public int minKnightMoves(int x, int y) {
        int dx[] = new int[] { -2, -1, +1, +2, +2, -1, +1, -2 };
        int dy[] = new int[] { +1, +2, +2, +1, -1, -2, -2, -1 };
        boolean[][] visited = new boolean[607][607];
        visited[302][302] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];
                if (r == x && c == y)
                    return steps;
                for (int i = 0; i < 8; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    if (visited[nr + 302][nc + 302])
                        continue;
                    visited[nr + 302][nc + 302] = true;
                    q.add(new int[] { nr, nc });
                }
            }
            steps++;
        }
        return steps;
    }
}