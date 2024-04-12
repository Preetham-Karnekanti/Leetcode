class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int[] onY = new int[3];
        int n = grid.length;
        int centerRow = n / 2;
        int centerCol = n / 2;
        int r = 0;
        int c = 0;
        while (r < centerRow && c < centerCol) {
            onY[grid[r][c]]++;
            r++;
            c++;
        }
        r = 0;
        c = n - 1;
        while (r < centerRow && c > centerCol) {
            onY[grid[r][c]]++;
            r++;
            c--;
        }
        r = centerRow;
        c = centerRow;
        while (r != grid.length) {
            onY[grid[r][c]]++;
            r++;
        }
        int otherThanY[] = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                otherThanY[grid[i][j]]++;
            }
        }
        otherThanY[0] -= onY[0];
        otherThanY[1] -= onY[1];
        otherThanY[2] -= onY[2];

        int y0 = onY[1] + onY[2];
        int y1 = onY[0] + onY[2];
        int y2 = onY[0] + onY[1];

        int otherThanY0 = otherThanY[1] + otherThanY[2];
        int otherThanY1 = otherThanY[0] + otherThanY[2];
        int otherThanY2 = otherThanY[0] + otherThanY[1];
        int ans[] = new int[6];
        ans[0] = y0 + otherThanY1;
        ans[1] = y0 + otherThanY2;
        ans[2] = y1 + otherThanY0;
        ans[3] = y1 + otherThanY2;
        ans[4] = y2 + otherThanY1;
        ans[5] = y2 + otherThanY0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            min = Math.min(min, ans[i]);
        }
        return min;
    }
}