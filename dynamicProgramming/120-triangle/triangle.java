class Solution {
    int dp[][];

    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--)
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
        }
        return dp[0][0];
    }

    public int helper(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = triangle.get(i).get(j) + Math.min(helper(triangle, i + 1, j), helper(triangle, i + 1, j + 1));
    }
}