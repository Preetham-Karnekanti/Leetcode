class Solution {
    int dx[] = new int[] { -1, 1, 0, 0 };
    int dy[] = new int[] { 0, 0, -1, 1 };
    int dp[][];

    public int longestIncreasingPath(int[][] matrix) {
        int max = 1;
        dp = new int[matrix.length][matrix[0].length];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, helper(matrix, i, j));
            }
        }
        return max;
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }

    public int helper(int matrix[][], int r, int c) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 1;
        if (dp[r][c] != -1)
            return dp[r][c];
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (!isValid(nr, nc, n, m) || matrix[nr][nc] <= matrix[r][c])
                continue;
            ans = Math.max(ans, 1 + helper(matrix, nr, nc));
        }
        return dp[r][c] = ans;
    }
}