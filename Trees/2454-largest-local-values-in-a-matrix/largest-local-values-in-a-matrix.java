class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int ans[][] = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                ans[i][j] = findMax(grid, i, j);
            }
        }
        return ans;
    }

    public int findMax(int mat[][], int startRow, int startCol) {
        int max = Integer.MIN_VALUE;
        for (int i = startRow; i <= startRow + 2; i++) {
            for (int j = startCol; j <= startCol + 2; j++) {
                max = Math.max(max, mat[i][j]);
            }
        }
        return max;
    }
}