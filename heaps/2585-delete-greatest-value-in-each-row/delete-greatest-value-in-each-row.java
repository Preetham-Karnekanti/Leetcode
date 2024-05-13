class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++)
            Arrays.sort(grid[i]);
        int ans = 0;
        int m = grid[0].length;
        int n = grid.length;
        for (int j = 0; j < m; j++) {
            int max = -1;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            ans += max;
        }
        return ans;
    }
}