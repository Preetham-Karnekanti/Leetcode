class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int dx[] = new int[] { -2, -1, +1, +2, +2, +1, -1, -2 };
        int dy[] = new int[] { +1, +2, +2, +1, -1, -2, -2, -1 };
        if (grid[0][0] != 0)
            return false;
        int n = grid.length;
        int end = n * n - 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 0 });
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            int moves = cur[2];
            if (moves == end)
                return true;
            int nextCell[] = getNextCellWithNextMove(dx, dy, moves + 1, r, c, grid);
            if (nextCell[0] == -1 && nextCell[1] == -1)
                return false;
            int nextMove[] = new int[] { nextCell[0], nextCell[1], moves + 1 };
            q.add(nextMove);
        }
        return true;
    }

    public int[] getNextCellWithNextMove(int dx[], int dy[], int key, int r, int c, int grid[][]) {
        for (int i = 0; i < 8; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (!isValid(nr, nc, grid))
                continue;
            if (grid[nr][nc] == key)
                return new int[] { nr, nc };
        }
        return new int[] { -1, -1 };
    }

    public boolean isValid(int r, int c, int grid[][]) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return false;
        return true;
    }
}