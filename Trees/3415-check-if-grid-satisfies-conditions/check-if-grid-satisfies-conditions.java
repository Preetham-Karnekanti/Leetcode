class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int cols = grid[0].length;
        int rows = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i < grid.length - 1 && grid[i][j] != grid[i + 1][j])
                    return false;
                if (j < cols - 1 && grid[i][j] == grid[i][j + 1])
                    return false;
            }
        }
        return true;
    }
}