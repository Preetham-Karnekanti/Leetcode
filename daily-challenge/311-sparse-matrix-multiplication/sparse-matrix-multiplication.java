class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int n = mat2[0].length;
        int ans[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < mat2.length; k++) {
                if (mat1[i][k] != 0) {
                    for (int j = 0; j < n; j++) {
                        ans[i][j] += mat1[i][k] * mat2[k][j];
                    }
                }
            }
        }
        return ans;
    }
}