class Solution {
    int dx[] = new int[] { -1, 0, 1, 0 };
    int dy[] = new int[] { 0, 1, 0, -1 };

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char grid[][], int i, int j) {
        grid[i][j] = '0';
        for (int x = 0; x < 4; x++) {
            int ni = i + dx[x];
            int nj = j + dy[x];
            if (!isValid(grid, ni, nj) || grid[ni][nj] == '0')
                continue;
            dfs(grid, ni, nj);
        }
    }

    public boolean isValid(char grid[][], int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return false;
        return true;
    }
}