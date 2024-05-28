class Solution {
    int dp[][];

    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[triangle.size()][triangle.size()];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(triangle, 0, 0);
    }

    public int helper(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = triangle.get(i).get(j) + Math.min(helper(triangle, i + 1, j), helper(triangle, i + 1, j + 1));
    }
}