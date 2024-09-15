class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        boolean vis[][][] = new boolean[n][m][health + 1];
        Queue<int[]> q = new LinkedList<>();
        if (grid.get(0).get(0) == 1)
            health--;
        q.add(new int[] { 0, 0, health });
        vis[0][0][health] = true;
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            int curHealth = cur[2];
            if (curHealth < 0)
                continue;
            if (curHealth > 0 && r == n - 1 && c == m - 1)
                return true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (isValid(nr, nc, n, m)) {
                    int newHealth = curHealth - (grid.get(nr).get(nc) == 0 ? 0 : 1);
                    if (newHealth > 0 && vis[nr][nc][newHealth] == false) {
                        vis[nr][nc][newHealth] = true;
                        q.add(new int[] { nr, nc, newHealth });
                    }
                }
            }
        }
        return false;
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }
}