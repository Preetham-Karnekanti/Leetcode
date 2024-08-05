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
                mat[rowStart][i] = count++;
            }
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                mat[i][colEnd] = count++;
            }
            for (int i = colEnd - 1; i >= colStart; i--)
                mat[rowEnd][i] = count++;
            for (int i = rowEnd - 1; i > rowStart; i--)
                mat[i][colStart] = count++;
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return mat;
    }
}