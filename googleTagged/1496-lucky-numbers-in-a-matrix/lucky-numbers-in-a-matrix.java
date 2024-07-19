class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int minE[] = new int[matrix.length];
        int maxE[] = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            minE[i] = min;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int max = 0;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            maxE[i] = max;
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == minE[i] && matrix[i][j] == maxE[j])
                    al.add(matrix[i][j]);
            }
        }
        return al;
    }
}