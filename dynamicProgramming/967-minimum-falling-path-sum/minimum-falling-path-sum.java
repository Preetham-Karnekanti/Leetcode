class Solution {
    int dp[];

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        for (int i = 0; i < m; i++)
            prev[i] = matrix[0][i];
        for (int i = 1; i < n; i++) {
            int[] cur = new int[m];
            for (int j = 0; j < m; j++) {
                int one = (int) 1e7;
                int two = (int) 1e7;
                int three = (int) 1e7;
                one = matrix[i][j] + prev[j];
                if (j - 1 >= 0)
                    two = matrix[i][j] + prev[j - 1];
                if (j + 1 < m)
                    three = matrix[i][j] + prev[j + 1];
                cur[j] = Math.min(one, Math.min(two, three));
            }
            prev = cur;
        }
        System.out.println(Arrays.toString(prev));
        for (int i = 0; i < m; i++)
            min = Math.min(min, prev[i]);
        return min;
    }

    // public int helper(int[][] grid, int i, int j) {
    // if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
    // return (int) 1e9;
    // if (i == grid.length - 1)
    // return grid[i][j];
    // if (dp[i][j] != Integer.MAX_VALUE)
    // return dp[i][j];
    // int s = grid[i][j] + helper(grid, i + 1, j);
    // int ld = grid[i][j] + helper(grid, i + 1, j - 1);
    // int rd = grid[i][j] + helper(grid, i + 1, j + 1);
    // return dp[i][j] = Math.min(s, Math.min(ld, rd));
    // }
}