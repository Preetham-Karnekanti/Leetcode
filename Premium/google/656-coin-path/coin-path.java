class Solution {
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int dp[] = new int[coins.length];
        Arrays.fill(dp, -1);
        int n = coins.length;
        if (coins[n - 1] == -1)
            return new ArrayList<>();
        int next[] = new int[n];
        Arrays.fill(next, -1);
        helper(coins, maxJump, 0, next, dp);
        ArrayList<Integer> ans = new ArrayList<>();
        int i;
        for (i = 0; i < next.length && next[i] > 0; i = next[i])
            ans.add(i + 1);
        if (i == n - 1 && coins[i] >= 0)
            ans.add(n);
        else
            return new ArrayList<>();
        return ans;
    }

    public int helper(int coins[], int maxJump, int idx, int next[], int[] dp) {
        int n = coins.length;
        if (idx >= n)
            return (int) 1e7;
        if(dp[idx] != -1)
            return dp[idx];
        if (idx == n - 1 && coins[idx] >= 0)
            return coins[idx];
        int min = (int) 1e7;
        for (int j = idx + 1; j <= Math.min(idx + maxJump, n - 1); j++) {
            if (coins[j] >= 0) {
                int cost = coins[idx] + helper(coins, maxJump, j, next, dp);
                if (cost < min) {
                    min = cost;
                    next[idx] = j;
                }
            }
        }
        return dp[idx] = min;
    }
}