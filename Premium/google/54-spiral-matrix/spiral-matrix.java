class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int startRow = 0;
        int startCol = 0;
        int endRow = n - 1;
        int endCol = m - 1;
        List<Integer> ans = new ArrayList<>();
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                ans.add(matrix[startRow][i]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                ans.add(matrix[i][endCol]);
            }
            if (startRow != endRow) {
                for (int i = endCol - 1; i >= startCol; i--) {
                    ans.add(matrix[endRow][i]);
                }
            }
            if (startCol != endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    ans.add(matrix[i][startCol]);
                }
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return ans;
    }
}