class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int countX[][] = count(grid, 'X');
        int countY[][] = count(grid, 'Y');
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (countX[i][j] >= 1 && countX[i][j] == countY[i][j])
                    ans++;
            }
        }
        return ans;
    }

    public int[][] count(char grid[][], char ch) {
        int arr[][] = new int[grid.length][grid[0].length];
        arr[0][0] = grid[0][0] == ch ? 1 : 0;
        for (int i = 1; i < grid[0].length; i++) {
            arr[0][i] = arr[0][i - 1] + (grid[0][i] == ch ? 1 : 0);
        }
        for (int i = 1; i < grid.length; i++) {
            arr[i][0] = arr[i - 1][0] + (grid[i][0] == ch ? 1 : 0);
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + (grid[i][j] == ch ? 1 : 0);
            }
        }
        return arr;
    }
}