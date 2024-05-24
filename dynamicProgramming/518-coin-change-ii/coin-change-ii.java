class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[] = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int cur[] = new int[amount+1];
            for (int j = 0; j <= amount; j++) {
                cur[j] = dp[j];
                if (coins[i] <= j) {
                    cur[j] += cur[j - coins[i]];
                }
            }
            dp = cur;
        }
        return dp[amount];
    }
}