class Solution {
    public boolean hasValidPath(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            if (r == grid.length - 1 && c == grid[0].length - 1)
                return true;
            int directions[][] = getDirections(grid[r][c]);
            for (int i = 0; i < directions.length; i++) {
                int nr = r + directions[i][0];
                int nc = c + directions[i][1];
                if (!isValid(nr, nc, grid) || vis[nr][nc])
                    continue;
                int tempDirections[][] = getDirections(grid[nr][nc]);
                for (int j = 0; j < tempDirections.length; j++) {
                    int tempR = nr + tempDirections[j][0];
                    int tempC = nc + tempDirections[j][1];
                    if (tempR == r && tempC == c) {
                        q.add(new int[] { nr, nc });
                        vis[nr][nc] = true;
                        break;
                    }
                }
            }
        }
        return false;
    }

    public boolean isValid(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
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
        return new int[][] { { -1, -1 } };
    }
}