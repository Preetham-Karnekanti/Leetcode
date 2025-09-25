class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        return helper(triangle, 0, 0, dp);
    }

    public static int helper(List<List<Integer>> input, int i, int j, int[][] dp) {
        if (i >= input.size() || j >= input.get(i).size())
            return (int) 1e9;
        if (i == input.size() - 1)
            return input.get(i).get(j);
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        return dp[i][j] = input.get(i).get(j) + Math.min(helper(input, i + 1, j, dp), helper(input, i + 1, j + 1, dp));
    }
}