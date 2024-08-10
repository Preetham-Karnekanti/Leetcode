class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int matrix[][] = new int[3 * n][3 * n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int baseRow = i * 3;
                int baseCol = j * 3;
                if (grid[i].charAt(j) == '\\') {
                    matrix[baseRow][baseCol] = 1;
                    matrix[baseRow + 1][baseCol + 1] = 1;
                    matrix[baseRow + 2][baseCol + 2] = 1;
                } else if (grid[i].charAt(j) == '/') {
                    matrix[baseRow][baseCol + 2] = 1;
                    matrix[baseRow + 1][baseCol + 1] = 1;
                    matrix[baseRow + 2][baseCol] = 1;
                }
            }
        }
        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                if (matrix[i][j] == 0) {
                    count++;
                    bfs(matrix, i, j);
                }
            }
        }

        return count;
    }

    public void bfs(int matrix[][], int row, int col) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        int n = matrix.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col });
        matrix[row][col] = 1;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, n) || matrix[nr][nc] == 1)
                    continue;
                matrix[nr][nc] = 1;
                q.add(new int[] { nr, nc });
            }
        }
    }

    public boolean isValid(int r, int c, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n)
            return false;
        return true;
    }
}