class Solution {
    Long dp[][];
    int mod = (int) 1e9 + 7;

    public int countVowelPermutation(int n) {
        dp = new Long[n + 1][26];
        return (int) ((helper(n - 1, 'a')
                + helper(n - 1, 'e')
                + helper(n - 1, 'i')
                + helper(n - 1, 'o')
                + helper(n - 1, 'u')) % mod);
    }

    public long helper(int n, char prev) {
        if (n == 0)
            return 1;
        long count = 0;
        if (dp[n][prev - 'a'] != null)
            return dp[n][prev - 'a'];
        if (prev == 'a') {
            count = helper(n - 1, 'e');
        }
        if (prev == 'e') {
            count = helper(n - 1, 'a') + helper(n - 1, 'i');
        }
        if (prev == 'i')
            count = helper(n - 1, 'a') + helper(n - 1, 'e') + helper(n - 1, 'o')
                    + helper(n - 1, 'u');
        if (prev == 'o')
            count = helper(n - 1, 'i') + helper(n - 1, 'u');
        if (prev == 'u')
            count = helper(n - 1, 'a');
        return  dp[n][prev - 'a'] = count % mod;
    }
}