class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int k = 1; k <= 4; k++) {
            rotate(mat);
            System.out.println("-------");
            if (isEqual(mat, target))
                return true;
        }
        return false;
    }

    public void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
            System.out.println(Arrays.toString(mat[i]));
        }
        int i = 0;
        int j = n - 1;
        while (i < j) {
            for (int row = 0; row < n; row++) {
                int temp = mat[row][i];
                mat[row][i] = mat[row][j];
                mat[row][j] = temp;
            }
            i++;
            j--;
        }
    }

    public boolean isEqual(int mat[][], int target[][]) {
        for (int i = 0; i < mat.length; i++) {
            if (!Arrays.equals(mat[i], target[i]))
                return false;
        }
        return true;
    }
}