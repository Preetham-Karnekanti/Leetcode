class Solution {
    int m = (int) 1e9 + 7;

    public int beautifulPartitions(String s, int k, int minLength) {
        long dp[][] = new long[s.length()][k + 1];
        for (long i[] : dp)
            Arrays.fill(i, -1);
        return (int) (helper(s, 0, k, minLength, dp) % m);
    }

    public long helper(String s, int idx, int k, int minLength, long[][] dp) {
        if (k < 0)
            return 0;
        if (idx == s.length()) {
            return k == 0 ? 1 : 0;
        }
        if (dp[idx][k] != -1)
            return dp[idx][k];
        if (!isPrime(s.charAt(idx)))
            return 0;
        long ways = 0;
        for (int i = idx + 1; i < s.length(); i++) {
            if (!isPrime(s.charAt(i))) {
                if (i - idx + 1 >= minLength) {
                    ways += helper(s, i + 1, k - 1, minLength, dp) % m;
                }
            }
        }
        return dp[idx][k] = ways % m;
    }

    public boolean isPrime(char ch) {
        return ch == '2' || ch == '3' || ch == '5' || ch == '7';
    }
}