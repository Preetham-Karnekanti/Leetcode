class Solution {
    int dp[][];

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] front = new int[n];
        for (int i = 0; i < n; i++)
            front[i] = triangle.get(n - 1).get(i);
        for (int i = n - 2; i >= 0; i--) {
            int[] cur = new int[i + 1];
            for (int j = i; j >= 0; j--) {
                cur[j] = Math.min(front[j], front[j + 1]) + triangle.get(i).get(j);
            }
            front = cur;
        }
        return front[0];
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