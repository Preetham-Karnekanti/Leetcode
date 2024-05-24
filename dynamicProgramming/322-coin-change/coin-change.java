class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount + 1];
        int prev[] = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = (int) 1e6;
        }

        for (int i = 1; i < coins.length; i++) {
            int cur[] = new int[amount + 1];
            for (int j = 0; j <= amount; j++) {
                int notTake = prev[j];
                int take = (int) 1e6;
                if (coins[i] <= j) {
                    take = 1 + cur[j - coins[i]];
                }
                cur[j] = Math.min(notTake, take);
            }
            prev = cur;
        }
        int ans = prev[amount];
        return ans >= (int) 1e6 ? -1 : ans;
    }
}