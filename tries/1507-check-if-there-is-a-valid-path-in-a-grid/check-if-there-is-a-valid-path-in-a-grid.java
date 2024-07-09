class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];
        vis[0][0] = true;
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            if (r == m - 1 && c == n - 1)
                return true;
            int[][] directions = getDirections(grid[r][c]);
            for (int i = 0; i < directions.length; i++) {
                int nr = r + directions[i][0];
                int nc = c + directions[i][1];
                if (!isValid(nr, nc, m, n) || vis[nr][nc])
                    continue;
                for (int[] dir : getDirections(grid[nr][nc])) {
                    if (nr + dir[0] == r && nc + dir[1] == c) {
                        q.add(new int[] { nr, nc });
                        if (nr == m - 1 && nc == n - 1)
                            return true;
                        vis[nr][nc] = true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return false;
        return true;
    }

    public int[][] getDirections(int type) {
        switch (type) {
            case 1:
                return new int[][] { { 0, -1 }, { 0, 1 } };
            case 2:
                return new int[][] { { -1, 0 }, { 1, 0 } };
            case 3:
                return new int[][] { { 0, -1 }, { 1, 0 } };
            case 4:
                return new int[][] { { 0, 1 }, { 1, 0 } };
            case 5:
                return new int[][] { { 0, -1 }, { -1, 0 } };
            case 6:
                return new int[][] { { 0, 1 }, { -1, 0 } };
        }
        return new int[][] { { 0, 0 }, { 0, 0 } };
    }
}