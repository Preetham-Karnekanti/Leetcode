class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean grid[][] = new boolean[n][n];
        for (int d[] : dig) {
            grid[d[0]][d[1]] = true;
        }
        int count = 0;
        for (int a[] : artifacts) {
            if (isValid(a, grid))
                count++;
        }
        return count;
    }

    public boolean isValid(int a[], boolean[][] grid) {
        for (int i = a[0]; i <= a[2]; i++) {
            for (int j = a[1]; j <= a[3]; j++) {
                if (!grid[i][j])
                    return false;
            }
        }
        return true;
    }
}