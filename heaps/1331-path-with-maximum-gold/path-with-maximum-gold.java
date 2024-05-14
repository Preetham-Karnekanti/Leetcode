class Solution {
    int dx[] = new int[] { -1, 1, 0, 0 };
    int dy[] = new int[] { 0, 0, -1, 1 };
    int ans[];

    public int getMaximumGold(int[][] grid) {
        ans = new int[1];
        boolean visited[][];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    solve(grid, i, j, 0);
                }
            }
        }
        return ans[0];
    }

    public void solve(int grid[][], int r, int c, int sum) {
        if (!isValid(r, c, grid.length, grid[0].length) || grid[r][c] == 0) {
            ans[0] = Math.max(ans[0], sum);
            return;
        }
        int temp = grid[r][c];
        grid[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            solve(grid, r + dx[i], c + dy[i], sum + temp);
        }
        grid[r][c] = temp;
    }

    public boolean isValid(int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c)
            return false;
        return true;
    }
}