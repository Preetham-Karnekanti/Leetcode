class Solution {
    Boolean dp[];

    public boolean winnerSquareGame(int n) {
        dp = new Boolean[n + 1];
        return helper(n);
    }

    public boolean helper(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        if (isPerfectSquare(n))
            return true;
        if (dp[n] != null)
            return dp[n];
        for (int i = 1; i * i <= n; i++) {
            boolean prev = helper(n - i * i);
            if (prev == false) {
                return dp[n] = true;
            }
        }
        return dp[n] = false;
    }

    public boolean isPerfectSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return sq * sq == n;
    }
}