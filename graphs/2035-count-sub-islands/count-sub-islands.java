public class Solution {
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        
        // Iterate over grid2 to find sub-islands
        int subIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    // If it's a potential sub-island, check if it's valid
                    if (dfs(grid1, grid2, i, j)) {
                        subIslands++;
                    }
                }
            }
        }
        return subIslands;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int x, int y) {
        int m = grid1.length;
        int n = grid1[0].length;

        // If out of bounds or water in grid2, return true (base case)
        if (x < 0 || x >= m || y < 0 || y >= n || grid2[x][y] == 0) {
            return true;
        }

        // Mark the cell as visited in grid2
        grid2[x][y] = 0;

        // Check if the current cell is a part of an island in grid1
        boolean isValid = grid1[x][y] == 1;

        // Continue DFS in all 4 directions
        isValid &= dfs(grid1, grid2, x + 1, y);
        isValid &= dfs(grid1, grid2, x - 1, y);
        isValid &= dfs(grid1, grid2, x, y + 1);
        isValid &= dfs(grid1, grid2, x, y - 1);

        return isValid;
    }
}
 