class Solution {
    int mod = 1000000007;
    Integer[][] cache; // The number of ways to get to sum i-th using the top j-th coin denomination

    public int numberOfWays(int n) {
        cache = new Integer[n + 1][4];
        return helper(n, 0) % mod;
    }

    private int helper(int n, int index) {
        if (n == 0) {
            return 1;
        }
        if (n < 0 || index == 4) {
            return 0;
        }
        if (cache[n][index] != null) {
            return cache[n][index];
        }
        int total = 0;
        if (index == 0) {
            total += helper(n, index + 1) % mod;
            total += helper(n - 1, index) % mod;
        } else if (index == 1) {
            total += helper(n, index + 1) % mod;
            total += helper(n - 2, index) % mod;
        } else if (index == 2) {
            total += helper(n, index + 1) % mod;
            total += helper(n - 4, index + 1) % mod;
            total += helper(n - 8, index + 1) % mod;
        } else if (index == 3) {
            total += helper(n, index + 1) % mod;
            total += helper(n - 6, index) % mod;
        }
        cache[n][index] = total % mod;
        return cache[n][index];
    }
}