class Solution {
    int[][] dir = {
            { 1, 1 },
            { 1, -1 },
            { -1, -1 },
            { -1, 1 }
    };
    int dp[][][][];

    public int lenOfVDiagonal(int[][] grid) {
        int res = 0;
        dp = new int[grid.length][grid[0].length][4][2];
        for (int i[][][] : dp) {
            for (int j[][] : i) {
                for (int k[] : j)
                    Arrays.fill(k, -1);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int direction = 0; direction < dir.length; direction++) {
                        res = Math.max(res, dfs(grid, i, j, direction, 0, 2) + 1);
                    }
                }
            }
        }
        return res;
    }

    public int dfs(int grid[][], int r, int c, int direction, int canTurn, int next) {
        int nr = r + dir[direction][0];
        int nc = c + dir[direction][1];

        if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != next) {
            return 0;
        }
        if (dp[nr][nc][direction][canTurn] != -1)
            return dp[nr][nc][direction][canTurn];
        int max = 1 + dfs(grid, nr, nc, direction, canTurn, 2 - next);
        if (canTurn == 0) {
            max = Math.max(max, 1 + dfs(grid, nr, nc, (direction + 1) % 4, 1, 2 - next));
        }
        return dp[nr][nc][direction][canTurn] = max;
    }
}