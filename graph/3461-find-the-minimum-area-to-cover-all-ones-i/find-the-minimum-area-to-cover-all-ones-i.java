class Solution {
    public int minimumArea(int[][] grid) {
        int lL = 2000;
        int lB = 2000;
        int rL = 0;
        int rB = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    lB = Math.min(lB, j);
                    rB = Math.max(rB, j);
                    lL = Math.min(lL, i);
                    rL = Math.max(rL, i);
                }
            }
        }
        return (rL - lL + 1) * (rB - lB + 1);
    }
}