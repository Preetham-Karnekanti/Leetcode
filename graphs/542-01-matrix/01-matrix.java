class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int ans[][] = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0)
                    q.add(new int[] { i, j });
            }
        }
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                ans[r][c] = distance;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    if (!isValid(nr, nc, rows, cols) || mat[nr][nc] == 0)
                        continue;
                    q.add(new int[] { nr, nc });
                    mat[nr][nc] = 0;
                }
            }
            distance++;
        }
        return ans;
    }

    public boolean isValid(int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols)
            return false;
        return true;
    }
}