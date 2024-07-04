class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(obstacleGrid, 0, 0, dp);
    }

    public static int helper(int[][] input, int i, int j, int[][] dp) {
        if (!isValid(i, j, input) || input[i][j] == 1)
            return 0;
        if (i == input.length - 1 && j == input[0].length - 1)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = helper(input, i + 1, j, dp) + helper(input, i, j + 1, dp);
    }

    public static boolean isValid(int r, int c, int[][] input) {
        if (r >= input.length || c >= input[0].length)
            return false;
        return true;
    }
}