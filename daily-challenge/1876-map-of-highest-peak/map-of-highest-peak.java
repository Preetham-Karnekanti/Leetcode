class Solution {
    int rows, cols;

    public int[][] highestPeak(int[][] isWater) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        rows = isWater.length;
        cols = isWater[0].length;
        Queue<int[]> q = new LinkedList<>();
        int ans[][] = new int[rows][cols];
        for (int row[] : ans) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    q.add(new int[] { i, j });
                }
            }
        }
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + cur[0];
                int nc = dy[i] + cur[1];
                if (!isValid(nr, nc))
                    continue;
                if (ans[nr][nc] > 1 + ans[cur[0]][cur[1]]) {
                    q.add(new int[] { nr, nc });
                    ans[nr][nc] = 1 + ans[cur[0]][cur[1]];
                }
            }
        }

        return ans;
    }

    public boolean isValid(int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols)
            return false;
        return true;
    }
}