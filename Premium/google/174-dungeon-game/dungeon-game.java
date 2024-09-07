class Solution {
    Integer dp[][];

    public int calculateMinimumHP(int[][] dungeon) {
        dp = new Integer[dungeon.length][dungeon[0].length];
        int res = helper(dungeon, 0, 0);
        if (res == 0 && dungeon[0][0] < 0)
            res = dungeon[0][0];
        return res >= 0 ? 1 : -1 * res + 1;
    }

    public int helper(int mat[][], int i, int j) {
        if (i == mat.length || j == mat[0].length)
            return Integer.MIN_VALUE;
        if (dp[i][j] != null)
            return dp[i][j];
        if (i == mat.length - 1 && j == mat[0].length - 1)
            return mat[i][j] >= 0 ? 0 : mat[i][j];
        int ans = mat[i][j] + Math.max(helper(mat, i + 1, j), helper(mat, i, j + 1));
        return dp[i][j] = ans >= 0 ? 0 : ans;
    }
}