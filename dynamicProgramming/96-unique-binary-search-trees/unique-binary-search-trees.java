class Solution {
    int dp[];
    public int numTrees(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }

    public int helper(int n) {
        if (n <= 1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += helper(i - 1) * helper(n - i);
        }
        return dp[n] = ans;
    }
}