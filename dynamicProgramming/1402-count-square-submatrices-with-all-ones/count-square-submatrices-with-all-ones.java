class Solution {
    int dx[];
    int dy[];
    int dp[][];

    public int countSquares(int[][] matrix) {
        dx = new int[] { 1, 1, 0 };
        dy = new int[] { 0, 1, 1 };
        dp = new int[matrix.length][matrix[0].length];
        int count = 0;
        for (int i = 0; i < matrix.length; i++)
            Arrays.fill(dp[i], -1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                    count += dfs(matrix, i, j);
            }
        }
        return count;
    }

    public int dfs(int[][] matrix, int x, int y) {
        if (!isValid(x, y, matrix.length, matrix[0].length))
            return 0;
        if (matrix[x][y] == 0) {
            dp[x][y] = 0;
            return 0;
        }
        if (dp[x][y] != -1)
            return dp[x][y];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            min = Math.min(min, dfs(matrix, nx, ny));
        }
        dp[x][y] = 1 + min;
        return dp[x][y];
    }

    public boolean isValid(int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols)
            return false;
        return true;
    }
}