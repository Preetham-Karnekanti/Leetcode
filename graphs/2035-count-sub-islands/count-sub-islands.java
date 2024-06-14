class Solution {

    int m;
    int n;

    boolean isSubIsland;

    public void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n || grid2[i][j] == 0)
            return;

        // marking as non subIsland as the i,j th cell is not present in grid1 and
        // proceeding further to exhaust this island
        if (grid1[i][j] != grid2[i][j]) {
            isSubIsland = false;
        }

        grid2[i][j] = 0; // once visited marking i,jth cell unreachable in future or in simple term
                         // visited.

        dfs(grid1, grid2, i + 1, j);
        dfs(grid1, grid2, i - 1, j);
        dfs(grid1, grid2, i, j + 1);
        dfs(grid1, grid2, i, j - 1);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        m = grid1.length;
        n = grid1[0].length;

        int subIslandCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    isSubIsland = true; // marking this island containing i,jth cell as sub-island
                    dfs(grid1, grid2, i, j);
                    if (isSubIsland)
                        subIslandCount++; // checking if it still remains sub-island, if so count it.
                }
            }
        }

        return subIslandCount;
    }
}