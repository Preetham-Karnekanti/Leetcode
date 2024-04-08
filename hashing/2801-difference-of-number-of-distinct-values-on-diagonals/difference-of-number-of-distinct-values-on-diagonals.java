class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int ans[][] = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans[i][j] = calculate(grid, i, j);
            }
        }
        return ans;
    }

    public int calculate(int[][] grid, int i, int j) {
        int temp = countTopLeft(grid, i - 1, j - 1);
        int temp1 = countBottomRight(grid, i + 1, j + 1);
        return Math.abs(temp - temp1);
    }

    public int countTopLeft(int grid[][], int r, int c) {
        HashSet<Integer> hs = new HashSet<>();
        while (r >= 0 && c >= 0)
            hs.add(grid[r--][c--]);

        return hs.size();
    }

    public int countBottomRight(int grid[][], int r, int c) {
        HashSet<Integer> hs = new HashSet<>();
        while (r < grid.length && c < grid[0].length) {
            hs.add(grid[r++][c++]);
        }
        return hs.size();
    }
}