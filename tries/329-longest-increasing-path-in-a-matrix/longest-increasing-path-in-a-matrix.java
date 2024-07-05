class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int r, int c, int[][] dp) {
        int dx[] = new int[] { 0, 0, -1, 1 };
        int dy[] = new int[] { 1, -1, 0, 0 };
        int ans = 1;
        if (dp[r][c] != -1)
            return dp[r][c];
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (!isValid(nr, nc, matrix) || matrix[nr][nc] <= matrix[r][c])
                continue;
            ans = Math.max(ans, 1 + dfs(matrix, nr, nc, dp));
        }
        return dp[r][c] = ans;
    }

    public boolean isValid(int r, int c, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }
}