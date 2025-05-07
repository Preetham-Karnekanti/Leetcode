class Solution {
    int dp[][];
    public int minimizeTheDifference(int[][] mat, int target) {
        dp = new int[mat.length][50001];
        for(int i[]: dp)
            Arrays.fill(i, -1);
        return helper(mat, target, 0, 0);
    }

    public int helper(int mat[][], int target, int row, int sum) {
        if (row == mat.length)
            return Math.abs(target - sum);
        if(dp[row][sum] != -1)
            return dp[row][sum];
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < mat[0].length; j++) {
            min = Math.min(min, helper(mat, target, row + 1, sum + mat[row][j]));
        }
        return dp[row][sum] = min;
    }
}