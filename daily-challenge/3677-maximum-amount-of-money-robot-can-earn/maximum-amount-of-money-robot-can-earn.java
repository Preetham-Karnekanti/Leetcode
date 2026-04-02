class Solution {
    Integer dp[][][];

    public int maximumAmount(int[][] coins) {
        dp = new Integer[coins.length][coins[0].length][3];
        return helper(coins, 0, 0, 2);
    }

    public int helper(int coins[][], int i, int j, int neutral) {
        if (i >= coins.length || j >= coins[0].length)
            return Integer.MIN_VALUE;
        if (i == coins.length - 1 && j == coins[0].length - 1) {
            return neutral > 0 ? Math.max(0, coins[i][j]) : coins[i][j];
        }
        if (dp[i][j][neutral] != null)
            return dp[i][j][neutral];
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        max1 = coins[i][j] + Math.max(helper(coins, i + 1, j, neutral), helper(coins, i, j + 1, neutral));
        if (neutral > 0 && coins[i][j] < 0) {
            max2 = Math.max(helper(coins, i + 1, j, neutral - 1), helper(coins, i, j + 1, neutral - 1));
        }
        return dp[i][j][neutral] = Math.max(max1,max2);
    }
}