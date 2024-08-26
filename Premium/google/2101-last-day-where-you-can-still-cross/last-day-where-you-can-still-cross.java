class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 0;
        int high = cells.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canCross(row, col, cells, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean canCross(int rows, int cols, int[][] cells, int day) {
        int grid[][] = new int[rows][cols];
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 0) {
                q.add(new int[] { 0, i });
                grid[0][i] = 1;
            }
        }

        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            if (r == rows - 1)
                return true;
            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + r;
                int nc = dy[i] + c;
                if (!isValid(nr, nc, rows, cols) || grid[nr][nc] == 1)
                    continue;
                q.add(new int[] { nr, nc });
                grid[nr][nc] = 1;
            }
        }
        return false;
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r >= n || c >= m || r < 0 || c < 0)
            return false;
        return true;
    }
}