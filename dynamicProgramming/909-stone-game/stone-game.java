class Solution {
    int dp[][];

    public boolean stoneGame(int[] piles) {
        dp = new int[piles.length][piles.length];
        int alice = helper(piles, 0, piles.length - 1);
        int total = 0;
        for (int i : piles)
            total += i;
        return alice > total / 2;
    }

    public int helper(int[] piles, int i, int j) {
        if (i >= piles.length || j < 0 || i > j)
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        int temp = helper(piles, i + 1, j - 1);
        int first = piles[i] + Math.min(helper(piles, i + 2, j), temp);
        int last = piles[j] + Math.min(helper(piles, i, j - 2), temp);
        return dp[i][j] = Math.max(first, last);
    }
}