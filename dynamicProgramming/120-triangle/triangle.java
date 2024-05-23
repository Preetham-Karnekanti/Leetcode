class Solution {
    int dp[][];

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return helper(triangle, 0, 0);
    }

    public int helper(List<List<Integer>> al, int i, int j) {
        if (i >= al.size() || j >= al.get(i).size())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int one = helper(al, i + 1, j);
        int two = helper(al, i + 1, j + 1);
        return dp[i][j] = Math.min(one, two) + al.get(i).get(j);
    }
}