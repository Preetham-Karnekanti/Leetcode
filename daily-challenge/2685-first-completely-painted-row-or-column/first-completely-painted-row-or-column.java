class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int rowCount[] = new int[rows];
        int colCount[] = new int[cols];
        HashMap<Integer, int[]> hm = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                hm.put(mat[i][j], new int[] { i, j });
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] cell = hm.get(arr[i]);
            int row = cell[0];
            int col = cell[1];
            rowCount[row]++;
            colCount[col]++;
            if (rowCount[row] == cols)
                return i;
            if (colCount[col] == rows)
                return i;
        }

        return -1;
    }
}