class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int i = 0;
        int sum = 0;
        while (i < n) {
            sum += mat[i][i];
            i++;
        }
        i = 0;
        int j = n - 1;
        while (i < n && j >= 0) {
            sum += mat[i][j];
            i++;
            j--;
        }
        if (n % 2 == 1) {
            int mid = n / 2;
            sum -= mat[mid][mid];
        }
        return sum;
    }
}