class Solution {
    public long sumRemoteness(int[][] grid) {
        long totalSum = 0;
        long ans = 0;
        ArrayList<long[]> sums = new ArrayList<>();
        boolean vis[][] = new boolean[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != -1 && vis[i][j] == false) {
                    long val[] = bfs(i, j, grid, vis);
                    sums.add(val);
                    totalSum += val[0];
                }
            }
        }
        for(long i[]: sums){
            long sum = i[0];
            long count = i[1];
            ans = ans + (totalSum - sum) * count;
        }
        return ans;
    }

    public long[] bfs(int row, int col, int grid[][], boolean vis[][]) {
        vis[row][col] = true;
        long neighbourSum = 0;
        long count = 0;
        Queue<int[]> q = new LinkedList<>();
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        q.add(new int[] { row, col });
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            neighbourSum += grid[r][c];
            count++;
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, grid.length) || grid[nr][nc] == -1 || vis[nr][nc] == true)
                    continue;
                q.add(new int[] { nr, nc });
                vis[nr][nc] = true;
            }
        }
        return new long[]{neighbourSum, count};
    }

    public boolean isValid(int r, int c, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n)
            return false;
        return true;
    }
}