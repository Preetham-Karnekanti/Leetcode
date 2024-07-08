class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int dp[][] = new int[n][k + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(piles, k, 0, dp);
    }

    public int helper(List<List<Integer>> piles, int k, int idx, int[][] dp) {
        if (idx >= piles.size() || k <= 0)
            return 0;
        if(dp[idx][k] != -1)
            return dp[idx][k];
        int skip = helper(piles, k, idx + 1, dp);
        int take = 0;
        int count = 0;
        for (int i = 0; i < piles.get(idx).size() && i < k; i++) {
            count += piles.get(idx).get(i);
            take = Math.max(take,count + helper(piles, k - i - 1, idx + 1, dp));
        }
        return dp[idx][k] = Math.max(take, skip);
    }
}