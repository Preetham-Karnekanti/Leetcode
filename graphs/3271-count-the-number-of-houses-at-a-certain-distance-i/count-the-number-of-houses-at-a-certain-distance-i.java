class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = 99999;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            mat[i][i] = 0;
            mat[i][i + 1] = 1;
            mat[i + 1][i] = 1;
        }
        mat[mat.length - 1][mat.length - 1] = 0;
        if (x != y) {
            mat[x - 1][y - 1] = 1;
            mat[y - 1][x - 1] = 1;
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                for (int k = 0; k < mat.length; k++) {
                    mat[j][k] = Math.min(mat[j][k], mat[j][i] + mat[i][k]);
                }
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] == 0)
                    continue;
                res[mat[i][j] - 1]++;
            }
        }
        return res;
    }
}