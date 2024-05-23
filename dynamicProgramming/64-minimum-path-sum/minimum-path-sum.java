class Solution {
    int dp[][];

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;
        int pre[] = new int[m];
        for (int i = 0; i < n; i++) {
            int cur[] = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    cur[i] = grid[i][j];
                else {
                    int up = grid[i][j];
                    int left = grid[i][j];
                    if (i > 0)
                        up += pre[j];
                    else
                        up += (int) 1e9;
                    if (j > 0)
                        left += cur[j - 1];
                    else
                        left += (int) 1e9;
                    cur[j] = Math.min(up, left);
                }
            }
            pre = cur;
        }
        return pre[m - 1];
    }
}