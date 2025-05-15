class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int matrix[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'W')
                    count = 0;
                else if (grid[i][j] == 'E')
                    count++;
                matrix[i][j] += count;
            }
            count = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 'W')
                    count = 0;
                else if (grid[i][j] == 'E')
                    count++;
                matrix[i][j] += count;
            }
        }
        for (int j = 0; j < m; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 'W')
                    count = 0;
                else if (grid[i][j] == 'E')
                    count++;
                matrix[i][j] += count;
            }
            count = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] == 'W')
                    count = 0;
                else if (grid[i][j] == 'E')
                    count++;
                matrix[i][j] += count;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, matrix[i][j]);
                }
            }
        }
        return max;
    }
}