class Solution {
    public int[][] generateMatrix(int n) {
        int mat[][] = new int[n][n];
        int count = 1;
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        while (count <= n * n) {
            for (int i = colStart; i <= colEnd; i++) {
                mat[rowStart][i] = count;
                count++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                mat[i][colEnd] = count;
                count++;
            }
            colEnd--;
            for (int i = colEnd; i >= colStart; i--) {
                mat[rowEnd][i] = count;
                count++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                mat[i][colStart] = count;
                count++;
            }
            colStart++;
        }
        return mat;
    }
}