class Solution {
    int dp[][];

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][triangle.get(n - 1).size()];
        for (int i = 0; i < dp[0].length; i++)
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][0];
    }

    public int helper(List<List<Integer>> al, int i, int j) {
        if (i >= al.size() || j >= al.get(i).size())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int one = (int) 1e7;
        int two = (int) 1e7;
        one = helper(al, i + 1, j) + al.get(i).get(j);
        two = helper(al, i + 1, j + 1) + al.get(i).get(j);
        return dp[i][j] = Math.min(one, two);
    }
}